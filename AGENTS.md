# AI Agent 개발 및 릴리즈 가이드라인 (AGENTS.md)

이 문서는 Breath Space 프로젝트의 지속적인 관리 및 빌드 릴리즈의 일관성을 유지하기 위해 AI 에이전트와 기여자가 준수해야 할 개발, 커밋, 버전 관리 규칙을 다룹니다.

---

## 1. 버전 관리 규칙 (Versioning Rules)

새로운 버전을 배포하거나 패치할 때는 프로젝트 내에 정의된 모든 버전 정보를 **동시에 일관되게 갱신**해야 합니다.

### 필수 수정 파일 및 동기화 포인트:
1. **`app/build.gradle.kts`**:
   - `versionCode` (단조 증가 정수, 예: `1` -> `2`)
   - `versionName` (SemVer 문자열, 예: `"1.0.0"` -> `"1.0.1"`)
2. **`CHANGELOG.md`**:
   - 상단에 새로운 버전 넘버와 날짜, 변경 사항 리스트를 추가합니다.
3. **`README.md`**:
   - 문서 하단 또는 소개 란의 현재 버전을 신규 버전명으로 변경합니다.

### 깃 태그 (Git Tagging):
버전 태그는 기본적으로 SemVer 형식인 `vX.Y.Z`를 사용합니다.
```bash
git tag v1.0.0
git push origin v1.0.0
```

---

## 2. 커밋 및 푸시 규칙 (Commit Guidelines)

코드 변경 사항은 철저하게 검증(컴파일 및 테스트 성공)된 상태에서 단일 단위로 쪼개어 커밋합니다.

### 커밋 메시지 권장 형식:
```text
<type>: <변경 요약 설명>

- 세부 변경 내용 1
- 세부 변경 내용 2
```

### 주요 커밋 타입 (Type):
- **`feat`**: 새로운 기능 추가 (예: `feat: 감정 로그 통계 화면 구현`)
- **`fix`**: 버그 및 오동작 수정 (예: `fix: 알림 복원 리시버 NullPointerException 예방`)
- **`docs`**: 문서 수정 및 추가 (README, AGENTS 등) (예: `docs: Play Store 자산 설명 추가`)
- **`refactor`**: 동작 변경 없는 코드 구조 개선 (예: `refactor: Repository 패키지 구조 리팩토링`)
- **`test`**: 단위 테스트 추가 또는 수정
- **`chore`**: Gradle 빌드 설정 변경, 종속성 버전 변경, 단순 자산 리플레이스 등

*커밋 메시지는 한국어 작성을 기본으로 하며, 변경 사항이 사용자가 이해할 수 있는 명확한 언어로 기술되어야 합니다.*

---

## 3. Play Store 자산 관리

- 스토어 자산 수정 시에는 `store-graphics/` 하위 파일들을 교체하며, 변경 사유를 반드시 `CHANGELOG.md`와 커밋 메시지에 명확하게 기록합니다.
- `release-notes.txt` 작성 시에는 `<ko>` 및 `<en>` 태그 형태로 구분하여 다국어 지원에 맞춘 릴리즈 노트를 출력합니다.

### 릴리즈 산출물 바탕화면 내보내기

사용자가 "새 버전 만들기" 또는 Play Console 제출용 산출물 생성을 요청하면 아래 Gradle task를 실행합니다.

```bash
./gradlew :app:exportReleaseToDesktop
```

이 task는 `bundleRelease`에 의존하므로 AAB를 먼저 빌드한 뒤, 사용자 바탕화면(OneDrive `바탕 화면` 우선)에 다음 두 파일을 내보냅니다.

- `BreathSpace-vX.Y.Z-vcN.aab`
- `BreathSpace-vX.Y.Z-vcN-release-notes.txt`

TXT는 `store-graphics/play-console-current/release-notes.txt`를 원본으로 사용하며, `<ko>` 및 `<en>` 블록이 모두 있어야 합니다.
