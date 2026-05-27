# 변경 이력 (CHANGELOG.md)

Breath Space 프로젝트의 버전별 변경 사항 일지입니다.

---

## [v1.0.0] - 2026-05-27

### 🚀 최초 공식 릴리즈 빌드 및 뼈대 리포지토리 구축

이 버전은 AI Studio에서 기본 추출된 프로토타입 소스를 바탕으로, 실제 프로덕션 출시 및 스토어 등록이 가능하도록 코드 전반과 빌드 환경을 체계적으로 개선한 최초 공식 배포 빌드입니다.

#### 1. 빌드 엔진 및 빌드 도구 안정화 (`chore`, `build`)
- **Gradle 멀티 모듈 지원 수립**: 비어 있던 프로젝트 루트 레벨에 `settings.gradle.kts` 및 `build.gradle.kts`를 수립하고 `:app` 모듈 통합.
- **버전 카탈로그 세팅**: `bebecup-android` 프로젝트에서 안정성이 검증된 `libs.versions.toml` 버전을 이식하여 `ksp`, `secrets`, `roborazzi` 및 Android 16 (API 36) SDK 빌드 환경 동기화.
- **Firebase BOM 추가**: 종속성 카탈로그에 Firebase BOM `"33.10.0"`을 이식하여 유연한 확장성 확보.

#### 2. 패키지 치환 및 모형 데이터 영구 제거 (`refactor`)
- **글로벌 패키지 이름 쇄신**: 템플릿 패키지명이던 `com.example`을 실제 마켓 등록용 ID인 `com.jeiel85.breathspace`로 치환.
- 16개 이상의 코틀린 소스 파일의 `package` 및 `import` 선언 일체 변경.
- 리소스 액세스용 빌드 아웃풋 클래스(`com.jeiel85.breathspace.R`) 참조 수정.
- `app/build.gradle.kts`의 `namespace` 및 `applicationId` 정적 재구성.

#### 3. 릴리즈 키 생성 및 빌드 보안 수립 (`chore`, `security`)
- **upload-key 신규 발급**: 마켓 배포용 서명인 `my-upload-key.jks`를 로컬에 새롭게 생성하고 `app/build.gradle.kts` 서명 구성을 fallback 연동하여 보안 수준 향상.
- 디버그 테스트용 `debug.keystore.base64` 디코더 디바이스 복구.

#### 4. 브랜딩 및 Play Store 등록 준비 (`docs`, `graphics`)
- **Key Visual 디자인**: 깃허브 메인을 수놓을 수려한 중심 그라데이션 글래스모피즘 베일 그래픽 생성 및 연동.
- **Play Store 그래픽 완료**: 스토어 규격(512×512 앱 아이콘, 1024×500 피처 배너)을 생성하여 `store-graphics/` 디렉토리에 전용 배치.
- **다국어 스토어 카피라이팅**: 한국어와 영어 두 버전으로 메인 타이틀, 80자 간략 소개, 4000자 상세 매뉴얼을 사전 제작 완료.
- **가이드라인 구축**: 이 버전 관리를 계도하는 `AGENTS.md` 지침서와 `LICENSE` 라이선스 배포 완료.

#### 5. Play Store 출시 감사 대응 (`fix`, `docs`, `graphics`)
- `versionName`을 `CHANGELOG.md` 및 README의 `v1.0.0` 표기와 동일한 SemVer 형식으로 동기화.
- Play Console 민감 권한 심사 부담을 낮추기 위해 정확 알람 권한(`SCHEDULE_EXACT_ALARM`)을 제거하고 일반 알람 예약으로 변경.
- 감정 로그와 세션 기록이 클라우드 백업/기기 이전으로 복원되지 않도록 백업 정책을 비활성화하고, 개인정보 문구를 실제 로컬 저장 동작과 일치하도록 정정.
- `store-graphics/` 및 `store-graphics/play-console-current/`의 앱 아이콘과 피처 그래픽을 Play Store 요구 규격(512×512, 1024×500)으로 재생성.
- `<ko>` 및 `<en>` 태그가 포함된 Play Console 릴리즈 노트 파일을 추가.
- Play Console 제출용 AAB와 릴리즈 노트 TXT를 바탕화면으로 내보내는 `:app:exportReleaseToDesktop` Gradle task를 추가.
