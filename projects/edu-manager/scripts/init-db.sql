-- EduManager 데이터베이스 초기화 스크립트

-- 기본 스키마 생성
CREATE SCHEMA IF NOT EXISTS edumanager;

-- 확장 모듈 설치 (UUID 생성용)
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- 시간대 설정
SET TIME ZONE 'Asia/Seoul';

-- 기본 설정 완료 메시지
DO $$
BEGIN
    RAISE NOTICE 'EduManager database initialized successfully!';
END $$;