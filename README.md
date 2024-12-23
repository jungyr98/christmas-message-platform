
# Christmas Message Platform Frontend :christmas_tree::love_letter:

<!-- 프로젝트 결과물 GIF -->
<img src="https://github.com/user-attachments/assets/c4a633df-974a-4869-99b7-daf4cf355324" width="400" />
<img src="https://github.com/user-attachments/assets/6f4cae32-101e-4533-afe9-5b4493c68d4f" width="400" />

## :grey_question: 소개
- Amazon EC2 배포를 위해 시작한 작은 프로젝트.
  * 개발자만의 테스트가 아니라 실제 사용자들이 자연스럽게 접속 후 이용하길 원했고, 그래서 링크를 공유한 사람에게 익명 메시지를 남길 수 있는 미니 프로젝트를 제작함
  * 인스타그램 스토리 등 모두가 조회할 수 있는 곳에 링크를 공유하면 여러 사용자들이 접속하고 광고가 노츨 됨
  * 단순한 UI로 쉽게 메시지를 전송할 수 있고, 전송 받은 메시지는 현재 DB에서 조회할 수 있음
  * 추후에 여러 사용자들이 링크를 공유할 수 있도록 로그인 서비스 및 메시지 조회 UI 등 개발 예정

## :bookmark_tabs: Spec

### Language
<img src="https://img.shields.io/badge/Java-407291?style=flat-square&logo=java&logoColor=white"/> <img src="https://img.shields.io/badge/Amazon Correctto 17-FF9900?style=flat-square&logo=amazon&logoColor=white"/> <img src="https://img.shields.io/badge/Node.js-5FA04E?style=flat-square&logo=Node.js&logoColor=white"/>   
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=white"/> <img src="https://img.shields.io/badge/React-61DAFB?style=flat-square&logo=react&logoColor=white"/> <img src="https://img.shields.io/badge/TypeScript-3178C6?style=flat-square&logo=typescript&logoColor=white"/> <img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=css3&logoColor=white"/>

### Build Tool
<img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=gradle&logoColor=white"/> <img src="https://img.shields.io/badge/Create React App-09D3AC?style=flat-square&logo=createreactapp&logoColor=white"/>

### Skill
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white"/> <img src="https://img.shields.io/badge/Lombok-a14933?style=flat-square&logo=lombok&logoColor=white"/> <img src="https://img.shields.io/badge/Spring Data JPA-6DB33F?style=flat-square&logo=spring&logoColor=white"/> <img src="https://img.shields.io/badge/Swagger-85EA2D?style=flat-square&logo=swagger&logoColor=white"/>   
<img src="https://img.shields.io/badge/.ENV-ECD53F?style=flat-square&logo=dotenv&logoColor=white"/> <img src="https://img.shields.io/badge/Ant Design-0170FE?style=flat-square&logo=antdesign&logoColor=white"/>

### DBMS
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white"/>

### Version Controll System
<img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white"/>

### IDE
<img src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=flat-square&logo=eclipseide&logoColor=white"/> <img src="https://img.shields.io/badge/VSCode-22a6f2?style=flat-square&logo=visualstudiocode&logoColor=white"/>

## :moneybag: 광고 삽입 수익 지표
![image](https://github.com/user-attachments/assets/6002511c-7ea2-499a-a033-75d260bca1fa)

### :pushpin: 사용법
#### Backend
- 테이블 생성
```
CREATE TABLE `스키마명`.`message` (
  `msg_no` INT NOT NULL AUTO_INCREMENT COMMENT '메시지 번호',
  `msg_content` VARCHAR(45) NOT NULL COMMENT '메시지 내용',
  `msg_sender_ip` VARCHAR(45) NULL COMMENT '메시지 전송자 IP',
  `msg_reg_date` DATETIME NOT NULL COMMENT '메시지 전송일자',
  PRIMARY KEY (`msg_no`))
COMMENT = '크리스마스 메시지 테이블';
```
- application-db.properties 생성 후 해당 정보 기입
```
spring.datasource.url=jdbc:mysql://아이피:포트/데이터베이스명
spring.datasource.username=유저명
spring.datasource.password=패스워드
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
#### Frontend
- .env 생성 후 해당 정보 기입
```
REACT_APP_SERVER_URL=http://아이피:포트
```
