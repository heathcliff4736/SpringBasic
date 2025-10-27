# 🧩 Simple Board Project (JSP & Servlet)

## 📘 프로젝트 개요
이 프로젝트는 **JSP/Servlet 기반의 게시판 웹 애플리케이션**으로,  
게시글 등록(Create), 조회(Read), 수정(Update), 삭제(Delete) 기능을 구현하였습니다.  

MVC 패턴을 기반으로 구조를 설계하고,  
**POST-Redirect-GET (PRG)** 패턴을 적용하여 새로고침 시 중복 요청을 방지했습니다.

---

## 🚀 주요 기능

| 기능 | 설명 |
|------|------|
| 📝 게시글 등록 | 작성자, 제목, 내용, 비밀번호 입력 후 게시글 등록 |
| 🔍 게시글 조회 | 게시글 목록 및 상세 페이지 제공 |
| ✏️ 게시글 수정 | 비밀번호 검증 후 게시글 수정 가능 |
| ❌ 게시글 삭제 | 비밀번호 검증 후 게시글 삭제 가능 |
| 🔒 비밀번호 검증 | 수정/삭제 시 입력한 비밀번호와 저장된 비밀번호 일치 여부 확인 |
| 🔄 PRG 패턴 적용 | 등록, 수정, 삭제 완료 후 redirect로 중복 요청 방지 |
| 🎨 JSTL + CSS 적용 | JSTL을 사용하여 JSP 표현식 최소화, 간단한 스타일링 적용 |

---

## 🧱 기술 스택

| 구분 | 기술 |
|------|------|
| Language | Java 17 |
| Framework | Servlet / JSP |
| View Template | JSP + JSTL |
| Build Tool | Gradle |
| Logging | Log4j2 |
| Database | MySQL (또는 MariaDB) |
| JDBC | HikariCP (또는 기본 JDBC 사용) |
| Server | Apache Tomcat 10.x |

---

## 📂 프로젝트 구조

```
📦 src
 ┣ 📂 main
 ┃ ┣ 📂 java
 ┃ ┃ ┗ 📂 com.ssg.board
 ┃ ┃ ┃ ┣ 📂 controller
 ┃ ┃ ┃ ┣ 📂 dto
 ┃ ┃ ┃ ┣ 📂 service
 ┃ ┃ ┃ ┣ 📂 dao
 ┃ ┃ ┃ ┗ 📂 domain
 ┃ ┣ 📂 webapp
 ┃ ┃ ┣ 📂 WEB-INF
 ┃ ┃ ┃ ┣ 📂 views
 ┃ ┃ ┃ ┃ ┣ 📜 list.jsp
 ┃ ┃ ┃ ┃ ┣ 📜 detail.jsp
 ┃ ┃ ┃ ┃ ┣ 📜 form.jsp
 ┃ ┃ ┃ ┃ ┗ 📜 error.jsp
 ┃ ┃ ┗ 📜 web.xml
 ┗ 📜 build.gradle
```

---

## 🔁 주요 흐름 (PRG 패턴 적용)

1️⃣ 사용자가 폼에서 게시글 등록 (POST `/posts/save`)  
2️⃣ 서버에서 DB 처리 후 redirect → `/posts/view?id={postId}`  
3️⃣ 사용자는 GET 요청으로 결과 페이지를 확인  

이로써 새로고침 시 중복 등록이 발생하지 않음.  
수정/삭제 로직에도 동일한 패턴을 적용.

---

## ⚙️ 실행 방법

1️⃣ **프로젝트 클론**
```bash
git clone https://github.com/yourusername/simple-board-servlet.git
```

2️⃣ **데이터베이스 생성**
```sql
CREATE DATABASE board CHARACTER SET utf8mb4;
USE board;

CREATE TABLE posts (
  post_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  writer VARCHAR(100) NOT NULL,
  passphrase VARCHAR(255) NOT NULL,
  created_at DATETIME DEFAULT NOW(),
  updated_at DATETIME DEFAULT NOW() ON UPDATE NOW()
);
```

3️⃣ **JDBC 설정 수정**
`ConnectionUtil` 또는 `application.properties` 파일의 DB 연결 정보 수정

4️⃣ **Tomcat 실행 후 브라우저 접속**
```
http://localhost:8080/posts
```

---

## 💡 학습 포인트

- JSP/Servlet 기반 **MVC 구조 설계**
- **DTO, DAO, Service Layer 분리**
- **PRG 패턴**을 통한 UX 개선
- **JSTL**로 JSP 로직 간소화
- **Log4j2**를 이용한 서버 로깅 처리
- **비밀번호 검증 로직**을 통한 기본 보안 처리

---

## 📸 화면 예시 *(선택 사항)*
> 📷 `list.jsp`, `detail.jsp`, `form.jsp` 스크린샷을 여기에 추가하면 더 완성도 높습니다.

---

## ✏️ 개선 예정
- [ ] 게시글 검색 기능 추가  
- [ ] 페이징 처리  
- [ ] 파일 업로드 기능  
- [ ] BCrypt를 이용한 비밀번호 암호화  

---

## 🧑‍💻 개발자
**Chandler Lee**  
> Java 백엔드 개발 공부 중 👨‍💻  
> Email: loookout97@gmail.com  
> GitHub: https://github.com/heathcliff4736

---
