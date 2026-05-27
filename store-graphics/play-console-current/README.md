# Breath Space Play Console Current Bundle

현재 Play Console 등록에 사용할 수 있도록 정리된 파일 묶음입니다.

## 포함 파일

- `icon-512.png` - Play 앱 아이콘, 512x512
- `feature-graphic-1024x500.png` - 피처 그래픽, 1024x500
- `release-notes.txt` - `<ko>` / `<en>` 태그가 포함된 릴리즈 노트
- `screenshots/` - 휴대전화 스크린샷 6장 + 보너스 2장 (1080x2340, Galaxy 실기기 캡처, 2026-05-27)

## 스크린샷 업로드 순서 권장

Play Console "전화" 슬롯에 아래 순서로 업로드하면 핵심 사용자 흐름이 자연스럽게 전달됩니다.

1. `screenshots/01-onboarding-intro.png` - 온보딩 첫 화면 "잠시 멈춰도 괜찮아요."
2. `screenshots/02-home.png` - 홈 화면 (호흡 구체, 호흡 시간 선택, 시작하기)
3. `screenshots/03-mood-check.png` - 세션 전 기분 체크 (5종)
4. `screenshots/04-breathing-session-exhale.png` - 호흡 세션 진행 중 (내쉬기 단계, 분홍 글로우)
5. `screenshots/05-session-complete.png` - 세션 완료 + 사후 기분 체크
6. `screenshots/06-reminder-settings.png` - 알림 설정 (시간/하루 횟수)

## 보너스 스크린샷

추가 업로드 또는 교체용으로 보관합니다.

- `screenshots/07-bonus-home-stats.png` - 홈 화면 하단의 "오늘의 호흡 기록" 통계 카드
- `screenshots/08-bonus-breathing-inhale.png` - 호흡 세션 진행 중 (들이마시기 단계, 청록 글로우)

## 출시 직전 점검

- AAB와 릴리즈 노트의 최신본은 `C:\Users\jeiel\OneDrive\바탕 화면`에 내보내져 있습니다 (`./gradlew.bat :app:exportReleaseToDesktop` 결과물).
- 7인치 / 10인치 태블릿 스크린샷은 폼팩터 배포 범위에 맞춰 별도로 캡처합니다 (현재 미작성).
