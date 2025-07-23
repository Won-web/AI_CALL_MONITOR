프로젝트 개요
AI CALL MONITOR 는 고객 상담 녹취 파일을 분석하여 AI 분석 결과를 제공하는 시스템입니다. 이 시스템은 업로드된 음성 파일을 AI 분석하고, 고객의 상담 내용을 정확하게 추출하여 실시간으로 분석합니다. 분석된 내용은 분석 결과 대시보드에서 확인할 수 있으며, 화자 구분 기능과 함께 제공됩니다.

이 시스템은 음성 파일 업로드, AI 분석 요청, 분석 결과를 웹을 통해 직관적으로 관리할 수 있도록 도와줍니다.

주요 기능
음성 파일 업로드: 사용자에게 음성 파일을 업로드할 수 있는 기능을 제공합니다.
AI 분석 요청: 업로드된 음성 파일에 대해 AI 분석을 요청할 수 있습니다.
화자 구분: 상담 중 여러 명의 화자가 존재할 경우, 이를 구분하여 분석합니다.

AI 분석 결과: 고객 상담 내용에 대한 AI 분석 결과를 확인할 수 있습니다.
실시간 데이터 표시: 실시간으로 분석된 데이터를 대시보드에 반영하여 표시합니다.

클론 받기:
git clone https://github.com/Won-web/AI_CALL_MONITOR.git

종속성 설치:
Java, Gradle 등의 종속성을 설치합니다. 해당 프로젝트는 Gradle을 사용하여 빌드합니다.
gradle build

실행:
서버를 시작하여 AI 분석 시스템을 실행할 수 있습니다.
gradle run

사용 기술
Backend: Java, Spring Boot
AI 분석: Whisper, Speech-to-Text (STT)
Frontend: HTML, CSS, JavaScript (관리자 대시보드)
Build Tool: Gradle
API: RESTful API
인증: 사용자 인증 (기타 요구 사항에 맞춰 추가 예정)

기타:
#[AI 콜 모니터링 PPT 파일](docs/AI콜모니터링_기능소개.pptx)
이 PPT에는 **고객 상담 내역 분석**, **AI 모델 학습 및 배포 과정**, **실시간 데이터 분석 시스템** 등이 포함되어 있습니다.
#시스템 대시보드 URL
[AI 콜 모니터링 대시보드](http://dev.skyand.co.kr:8012/dashboard)


