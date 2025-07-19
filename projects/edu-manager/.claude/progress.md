# 📋 EduManager 프로젝트 진행 상황

## 🎯 프로젝트 개요
- **프로젝트명**: EduManager - 통합 학원 관리 시스템
- **목적**: 중소규모 학원의 운영 효율성 극대화를 위한 올인원 솔루션
- **개발 환경**: IntelliJ IDEA + macOS (MacBook)

## ✅ 완료된 작업들

### 1. 프로젝트 기획 및 설계 (2025-07-19)
- [x] 협업 규칙 정립 (.claude/collaboration-rules.md)
- [x] 기술 스택 선정 및 정리 (.claude/tech-stack.md)
- [x] 프로젝트 기획안 정리 (.claude/project-overview.md)
- [x] 개발 환경 정보 정리 (.claude/development-environment.md)

### 2. 기술 스택 확정
**Backend:**
- Java 21 + Spring Boot 3.5.3
- PostgreSQL (메인 DB) + MongoDB (NoSQL) + Redis (캐시)
- Apache Kafka (KRaft 모드, Zookeeper 없음)
- MapStruct, Swagger, JWT

**Frontend:**
- React + TypeScript + Vite
- MUI (Material-UI)
- pnpm (패키지 매니저)

**코드 품질:**
- ESLint + Prettier

### 3. 프로젝트 구조 설계 및 생성
**멀티모듈 Gradle 구조:**
```
edu-manager/
├── .claude/                    # 프로젝트 설정 및 문서
├── backend/                    # Spring Boot 멀티모듈
│   ├── core/
│   │   ├── common/            # 공통 유틸리티, 예외 처리
│   │   ├── security/          # JWT, 인증/인가
│   │   └── infrastructure/    # 공통 인프라 인터페이스
│   ├── domain/
│   │   ├── user/             # 사용자 도메인
│   │   └── student/          # 학생 도메인 (출석, 성적 포함)
│   ├── application/
│   │   ├── api/              # 메인 REST API 서버
│   │   ├── admin/            # 관리자 서비스
│   │   └── batch/            # 배치 처리 서비스
│   └── infrastructure/
│       ├── database/         # DB 구현체 (PostgreSQL, MongoDB)
│       ├── messaging/        # Kafka 구현체
│       └── cache/            # Redis 구현체
└── frontend/                   # React + TypeScript 프로젝트
```

### 4. Gradle 멀티모듈 설정
- [x] 루트 settings.gradle 설정 (모든 서브모듈 등록)
- [x] 루트 build.gradle 설정 (공통 설정)
- [x] 각 서브모듈별 build.gradle 생성 (9개 모듈)
- [x] 의존성 관계 설정
  - application:api → 모든 모듈 의존
  - domain:student → domain:user 의존
  - infrastructure → core:infrastructure 의존

### 5. 개발 환경 설정
**Docker Compose 설정:**
- [x] PostgreSQL 16 (포트: 5432)
- [x] MongoDB 7.0 (포트: 27017)
- [x] Redis 7.2 (포트: 6379)
- [x] Apache Kafka (KRaft 모드, 포트: 9092)
- [x] pgAdmin 8.2 (포트: 5050)

**환경 설정 파일:**
- [x] .env 파일 (환경 변수)
- [x] backend/.env 파일 (백엔드 전용)
- [x] .gitignore 파일 (Git 제외 파일)
- [x] scripts/init-db.sql (PostgreSQL 초기화)

### 6. 백엔드 기본 설정
**Spring Boot Application:**
- [x] EduManagerApplication.java (메인 클래스)
- [x] application.yml (통합 데이터베이스 설정)
  - PostgreSQL + MongoDB + Redis + Kafka 설정
  - 개발/운영 프로파일 분리
  - 연결 풀 최적화
- [x] HealthController.java (헬스체크 API)
  - GET /api/health - 전체 상태 확인
  - GET /api/ping - 간단한 응답 확인

**의존성 설정:**
- [x] Spring Boot Starter 패키지들
- [x] PostgreSQL Driver
- [x] MongoDB Starter (임시 주석 처리)
- [x] Redis Starter
- [x] Kafka
- [x] JWT (jsonwebtoken 0.12.3)
- [x] MapStruct 1.5.5.Final
- [x] Swagger (springdoc-openapi 2.2.0)

### 7. 프론트엔드 기본 설정
- [x] Vite + React + TypeScript 프로젝트 생성
- [x] 기본 프로젝트 구조 설정

## 🔄 현재 상태
- ✅ **백엔드 실행 성공** - Spring Boot 애플리케이션 정상 기동
- ⚠️ **MongoDB 설정 임시 비활성화** - Repository 패키지 미생성으로 주석 처리
- ✅ **Docker 서비스 구성 완료** - 필요 시 전체 인프라 실행 가능
- ✅ **멀티모듈 구조 완성** - 확장 가능한 아키텍처 구축

## 📋 다음 단계 (우선순위)

### 즉시 가능한 작업들
1. **User 도메인 엔티티 설계 및 구현**
   - 사용자 유형별 엔티티 설계 (학원관리자/강사/학부모/학생)
   - JPA 엔티티 및 Repository 구현

2. **Student 도메인 엔티티 설계 및 구현**
   - 학생 정보, 출석, 성적 엔티티 설계
   - User 도메인과의 연관관계 설정

3. **기본 인증 시스템 구현**
   - JWT 기반 로그인/로그아웃
   - Spring Security 설정
   - 사용자 역할별 권한 관리

4. **MongoDB 및 Redis 설정 완성**
   - 올바른 모듈 위치에 설정 구현
   - Repository 패키지 생성

### 중장기 작업들
5. **REST API 설계 및 구현**
6. **프론트엔드 기본 구조 설정**
7. **실시간 채팅 시스템 (WebSocket)**
8. **알림 시스템 (Kafka 기반)**

## 🚨 주의사항 및 이슈
1. **협업 규칙 준수**: .claude 폴더 외 파일 직접 수정 금지
2. **MongoDB 설정**: 현재 임시 비활성화 상태, 올바른 위치에 재구성 필요
3. **코드 설명**: 모든 코드 제공 시 상세한 주석 포함 필요
4. **최신 기술**: WebFetch를 통한 최신 라이브러리 문서 확인 후 코드 제공

## 📊 진행률
- **프로젝트 기획**: 100% ✅
- **환경 설정**: 90% ⚠️ (MongoDB 설정 보완 필요)
- **백엔드 기본 구조**: 70% 🔄 (도메인 구현 필요)
- **프론트엔드 기본 구조**: 20% 🔄 (기본 생성만 완료)
- **전체 진행률**: 약 30% 🔄

---
**마지막 업데이트**: 2025-07-19
**다음 목표**: User 도메인 엔티티 설계 및 구현