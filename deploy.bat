@echo off

REM [1] Docker 이미지 빌드
echo ==== Build Docker image ====
docker build -t shinhan-stt . 
if %errorlevel% neq 0 (
    echo [ERROR] Docker build 실패. 배포 중단.
    exit /b %errorlevel%
)

REM [2] 기존 컨테이너 중지 및 삭제
echo ==== Termination and deletion of existing contracts ====
docker stop shinhan-stt-container
if %errorlevel% neq 0 echo "기존 컨테이너 없음 (중지 생략)"
docker rm shinhan-stt-container
if %errorlevel% neq 0 echo "기존 컨테이너 없음 (삭제 생략)"

REM [3] 새로운 컨테이너 실행
echo ==== Run a new container ====
docker run -d --name shinhan-stt-container ^
  -p 8012:18082 ^
  -v C:/ProgramData/Jenkins/.jenkins/workspace/shinhan-stt/uploads:/uploads ^
  -e "SPRING_PROFILES_ACTIVE=prod" ^
  shinhan-stt

echo ==== Deployment complete ====