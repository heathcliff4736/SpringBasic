# Spring Practice Projects

Spring Framework를 학습하며 작성한 연습 프로젝트 모음입니다.

## 📚 프로젝트 개요

Spring MVC와 MyBatis를 활용한 게시판 시스템 구현을 통해 웹 애플리케이션 개발의 기본을 학습했습니다.

---

## 🎯 Spring Web MVC Board

### 기술 스택
- **Framework**: Spring MVC
- **ORM**: MyBatis
- **View**: JSP, JSTL
- **UI**: Bootstrap 5
- **기타**: Lombok, ModelMapper, Validation API

### 구현 기능
- 게시글 CRUD (등록/조회/수정/삭제)
- 페이징 처리
- 검색 기능 (제목/작성자)
- 조회수 자동 증가
- 파일 첨부 기능
- 입력값 검증 (Validation)

---

## 📖 학습한 핵심 개념

### 1. Spring MVC 아키텍처
- Controller-Service-Mapper 3계층 구조 설계
- `@Controller`, `@RequestMapping`을 통한 요청 처리
- `@GetMapping`, `@PostMapping`으로 HTTP 메서드 분리
- 의존성 주입(DI)을 통한 느슨한 결합

### 2. MyBatis 데이터베이스 연동
- XML Mapper를 활용한 SQL 쿼리 관리
- 파라미터 바인딩과 결과 매핑
- CRUD 쿼리 작성 및 실행

### 3. Validation과 에러 처리
- `@Valid`를 통한 입력값 검증
- `BindingResult`로 검증 오류 확인
- `RedirectAttributes`를 통한 데이터 전달
- Flash Attribute 활용

### 4. JSP와 JSTL
- JSTL을 활용한 동적 페이지 렌더링
- `<c:forEach>`, `<c:if>`, `<c:out>` 활용
- EL(Expression Language)을 통한 데이터 표현

### 5. 페이징 처리
- 페이지네이션 로직 구현
- 이전/다음 페이지 버튼 처리
- JavaScript를 통한 동적 폼 제출

### 6. 검색 기능
- GET 방식의 검색 쿼리 처리
- 검색어 유지 및 초기화
- 검색과 페이징의 결합

### 7. DTO/VO 패턴
- 계층 간 데이터 전달 객체 분리
- ModelMapper를 통한 객체 간 자동 매핑

### 8. 파일 업로드
- 파일 경로와 원본 파일명 분리 저장
- NULL 처리를 위한 `jdbcType` 설정

---

## 🎓 프로젝트를 통해 배운 것

- Spring MVC의 요청-응답 흐름 이해
- 계층형 아키텍처 설계 및 구현
- MyBatis를 활용한 데이터베이스 연동
- JSP/JSTL을 활용한 동적 웹 페이지 구현
- 페이징, 검색 등 기본 기능 구현
- Validation을 통한 데이터 검증 처리

---

## 📌 기술적 특징

- Controller, Service, Mapper로 계층 분리
- ModelMapper를 활용한 객체 매핑 자동화
- Lombok을 활용한 코드 간소화

---

## 🚀 향후 개선 방향

- Spring Security를 활용한 인증/인가 기능
- 댓글 기능 추가
- RESTful API로 리팩토링
- JPA 학습 및 적용
```



