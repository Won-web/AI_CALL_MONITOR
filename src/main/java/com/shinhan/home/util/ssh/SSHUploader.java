package com.shinhan.home.util.ssh;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.userauth.keyprovider.OpenSSHKeyFile;
import net.schmizz.sshj.userauth.password.PasswordFinder;
import net.schmizz.sshj.userauth.password.Resource;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.stream.Collectors;

import net.schmizz.sshj.connection.channel.direct.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSHUploader {
	
	private static final Logger logger = LoggerFactory.getLogger(SSHUploader.class);
	
    public static void upload(String localFilePath, String remoteDir, String remoteHost, int port,
                              String username, String pemFilePath, String passphrase) throws IOException {

        File file = new File(localFilePath);
        if (!file.exists()) {
            throw new IllegalArgumentException("업로드할 파일이 존재하지 않습니다: " + localFilePath);
        }

        SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new PromiscuousVerifier());
        ssh.connect(remoteHost, port);

        PasswordFinder finder = new PasswordFinder() {
			@Override
			public char[] reqPassword(Resource<?> resource) {
				return passphrase.toCharArray();
			}

			@Override
			public boolean shouldRetry(Resource<?> resource) {
				return false;
			}
        };

        OpenSSHKeyFile keyFile = new OpenSSHKeyFile();
        keyFile.init(new File(pemFilePath), finder);

        ssh.authPublickey(username, keyFile);
        try (SFTPClient sftpClient = ssh.newSFTPClient()) {
            sftpClient.put(localFilePath, remoteDir + "/" + file.getName());
            sftpClient.chmod(remoteDir + "/" + file.getName(), 0755);
            logger.info("EC2 업로드 성공: ", file.getName());
        } catch (Exception e) {
            logger.error("EC2 업로드 실패: ", e.getMessage(), e);
            throw new IOException("EC2 업로드 중 오류 발생", e); 
        } finally {
            ssh.disconnect();
        }
    }
    
    public static void executeCommand(String remoteHost, int port, String username, String pemFilePath,
    								  String passphrase, String command) throws IOException {

		SSHClient ssh = new SSHClient();
		ssh.addHostKeyVerifier(new PromiscuousVerifier());
		ssh.connect(remoteHost, port);
		
		PasswordFinder finder = new PasswordFinder() {
		
			@Override
			public char[] reqPassword(Resource<?> resource) {
				return passphrase.toCharArray();
			}
			
			
			@Override
			public boolean shouldRetry(Resource<?> resource) {
				return false;
			}
		};
		
		OpenSSHKeyFile keyFile = new OpenSSHKeyFile();
		keyFile.init(new File(pemFilePath), finder);
		
		ssh.authPublickey(username, keyFile);
		
		try (Session session = ssh.startSession()) {
			Session.Command cmd = session.exec(command);
			
			String output = new BufferedReader(new InputStreamReader(cmd.getInputStream()))
			.lines().collect(Collectors.joining("\n"));
			String errorOutput = new BufferedReader(new InputStreamReader(cmd.getErrorStream()))
			.lines().collect(Collectors.joining("\n"));
			
			cmd.join();
			
			if (cmd.getExitStatus() != 0) {
				logger.error("원격 명령 실행 실패 (exit {}): {}", cmd.getExitStatus(), errorOutput);
				throw new IOException("원격 명령 실행 중 오류 발생: " + errorOutput);
			}
			logger.info("원격 명령 실행 성공: {}", output);
		} catch (Exception e) {
			logger.error("원격 명령 실행 중 예외 발생: {}", e.getMessage(), e);
			throw new IOException("원격 명령 실행 중 예외 발생", e);
		} finally {
			ssh.disconnect();
		}
    }


}
