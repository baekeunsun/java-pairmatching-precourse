# 페어매칭관리 애플리케이션

## 프로젝트 소개
우테코 과정에 있는 백엔드와 프론트엔드를 페어 매칭하여 페어프로그래밍으로 진행한다.
각 과정은 5단계로 나누어져 진행되고, 이를 레벨이라 칭한다. 미션 시작 전 페어를 매칭하는데, 다양한 페어를 위해 중복 페어는 만날 수 없다.
페어를 매칭하고, 조회하고, 초기화하는 프로그램이다.

## 개발 환경
JDK 11

## 기능 소개
1. 기능 선택
- [x] 입력 문구 출력
- [x] 아래 4가지 기능 선택
```
  1. 페어 매칭
  2. 페어 조회
  3. 페어 초기화
  Q. 종료
```

2. 페어 매칭
- [x] 페어 매칭 안내 문구 출력
- [x] 매칭하고자 하는 과정, 레벨, 미션 입력받음
- [x] 페어 매칭하기
  - [x] 크루 명단 파일 읽어오기
  - [x] 랜덤으로 섞인 크루 목록 생성
    - [x] 크루들의 이름 목록 List<String>
    - [x] 크루 목록의 순서를 랜덤, `camp.nextstep.edu.missionutils.Randoms`의 shuffle 메서드를 활용
  - [x] 함께 수행할 페어를 두명씩 매칭
    - [x] 랜덤으로 섞인 페어 목록에서 페어 매칭을 할 때 앞에서부터 순서대로 두명씩
    - [x] 홀수인 경우 한 페어는 3인 : 마지막 남은 크루는 마지막 페어에 포함
  - [x] 같은 레벨에서 이미 맺은 크루라면 랜덤 목록을 재생성하여 페어 매칭
  - [x] 3회 시도까지 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없으면 에러 메시지를 출력
  - [x] 이미 매칭된 페어일 경우 안내 문구와 재매칭할것인지 입력받음
    - [x] 네
      - [x] 매칭된 정보 삭제
      - [x] 재매칭
    - [x] 아니오
      - [x] 메뉴 선택으로 돌아감

3. 페어 조회
- [x] 페어 조회 안내 문구 출력
- [x] 과정, 레벨, 미션을 선택하면 해당 미션의 페어 정보 출력
- [x] 매칭 이력 없을 시 이력 없다고 안내

4. 페어 초기화
- [x] 페어 초기화

5. 종료
- [x] 프로그램 종료

6.예외 처리
- [x] 기능 선택 시 1,2,3,Q가 아닐 경우
- [x] 페어 조회를 했으나, 매칭된 페어가 없을 경우
- [x] 조건 입력 시, 과정, 레벨, 미션을 입력하지 않았을 경우
  - [x] 과정이 백엔드, 프론트엔드가 아닐 경우
  - [x] 레벨이 레벨1~레벨4가 아닐 경우
  - [x] 없는 미션을 입력했을 경우
  - [x] 세가지 전부 입력하지 않았을 경우

## 고려사항
- [] 매칭에 필요한 크루들의 이름을 파일 입출력을 통해 불러옴
- [] src/main/resources/backend-crew.md과 src/main/resources/frontend-crew.md 파일을 이용
- [] 두 파일의 내용은 수정이 가능하다. 수정 시 크루들의 이름은 중복될 수 없음
- [] 파일 입출력 방법은 자바 파일 읽기나 자바 파일 입출력과 같은 키워드로 구글링해서 찾을 수 있음
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, [ERROR]로 시작하는 에러 메시지를 출력 후 해당 부분부터 다시 입력을 받음
- [] 프로그램을 실행하는 시작점은 Application의 main()
- [] 자바 코드 컨벤션을 지키면서 프로그래밍
- [] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용
- [] 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현
- [] else 예약어를 쓰지 않음
- [] build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않음
- [] 프로그램 종료 시 System.exit()를 호출하지 않음
- [] 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있음