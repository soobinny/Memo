# 메모장 프로젝트 (Memo)

- 언어: Java  
- 프레임워크: Spring Boot  
- IDE: IntelliJ IDEA  


## 프로젝트 개요

Spring Boot 기반의 간단한 메모 관리 API  
REST API 설계를 통해 메모장 구현  
클라이언트 요청을 받아 inmemory 구조로 메모를 저장하고 응답  
DTO를 통한 요청/응답 분리, Entity 설계, RESTful 컨트롤러 구현 등 핵심 개념 학습 목적


## 주요 기능

- @RestController, @RequestMapping, @RequestBody 등 Spring MVC 어노테이션 활용
- 클라이언트 요청(Request)과 응답(Response)을 위한 DTO 설계 및 분리
- Memo Entity를 통해 ID, 제목, 내용을 가진 메모 데이터 모델 정의
- Map<Long, Memo>을 이용한 간단한 inmemory 데이터 저장소 구성
- 계층 분리를 고려한 Controller / DTO / Entity 구조 설계


## CRUD

- 메모 생성 (Create): 제목과 내용을 입력받아 고유 ID를 부여한 메모 등록  
- 메모 조회 (Read): ID로 특정 메모를 조회하거나, 전체 메모 목록 조회  
- 메모 수정 (Update): ID로 메모를 찾아 제목과 내용을 수정  
- 메모 삭제 (Delete): ID로 특정 메모를 삭제  
- ID 자동 생성: 가장 큰 ID 값을 기준으로 1씩 증가하며 관리  
- 유효하지 않은 ID 요청 시 예외 응답 반환 처리 구현

  

## 클래스 구조
```
memo/
├── MemoApplication.java : 스프링 부트 실행 클래스
├── controller/
│ └── MemoController.java : 메모 생성 요청 처리
├── dto/
│ ├── MemoRequestDto.java : 메모 생성 요청 DTO
│ └── MemoResponseDto.java : 메모 응답 DTO
└── entity/
└── Memo.java : 메모 데이터 모델 클래스
```
