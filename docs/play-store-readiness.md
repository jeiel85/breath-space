# Play Store Readiness Audit

점검일: 2026-05-27

## 완료

- `app/build.gradle.kts`의 `versionName`을 `1.0.0`으로 맞춰 `CHANGELOG.md`, README, 앱 내 버전 표기와 동기화했습니다.
- `SCHEDULE_EXACT_ALARM` 권한을 제거하여 Play Console 민감 권한 선언 부담을 줄였습니다.
- 알림 예약은 `setAndAllowWhileIdle` / `set` 기반의 일반 알람으로 변경했습니다.
- 로컬 우선 개인정보 방침과 맞도록 앱 백업을 비활성화하고 데이터 추출 규칙에서 DB/SharedPreferences를 제외했습니다.
- README, 앱 내 개인정보 안내, 스토어 상세 설명의 "암호화 저장" 표현을 실제 구현에 맞는 "앱 전용 로컬 저장소" 표현으로 정정했습니다.
- 앱 아이콘과 피처 그래픽을 Play Console 규격에 맞게 재생성했습니다.
- `<ko>` / `<en>` 태그가 포함된 릴리즈 노트를 `store-graphics/play-console-current/release-notes.txt`에 추가했습니다.
- `./gradlew.bat test` 및 `./gradlew.bat bundleRelease` 성공을 확인했습니다.
- `./gradlew.bat :app:exportReleaseToDesktop`로 Play Console 제출용 AAB/TXT를 바탕화면에 내보낼 수 있습니다.

## 추가 완료 (2026-05-27)

- Galaxy 실기기(1080x2340)에서 Play Console용 휴대전화 스크린샷 6장 + 보너스 2장을 캡처해 `store-graphics/play-console-current/screenshots/`에 정리했습니다. 업로드 순서와 보너스 활용법은 같은 폴더의 `README.md`를 참고하세요.

## 출시 전 남은 항목

- Play Console의 데이터 보안 섹션에는 "데이터 수집 없음", "데이터 공유 없음" 방향으로 입력하되, 기기 내 앱 활동/기분 로그가 로컬에만 저장된다는 점을 설명해야 합니다.
- 업로드 키는 현재 `.keystore/my-upload-key.jks` 로컬 fallback 또는 환경 변수 기반입니다. `.keystore/`는 Git 추적에서 제외되어 있으므로 별도 백업이 필요하며, 필요하면 `KEYSTORE_PATH`, `STORE_PASSWORD`, `KEY_PASSWORD`로 빌드할 수 있습니다.
- 7인치 / 10인치 태블릿 스크린샷은 폼팩터 배포 범위에 맞춰 별도 캡처가 필요합니다 (현재 미작성).
