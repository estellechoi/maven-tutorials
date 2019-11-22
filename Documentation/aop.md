# 스프링 AOP
  > 스프링 프레임워크를 사용한 프로젝트를 할 때 관점 지향 프로그래밍 해보기

### 관점 지향 프로그래밍(AOP, Aspect Oriented Programming) 이란 ?
- 하나의 프로그램을 관점(혹은 관심사)라는 논리적인 단위로 분리하여 관리하는 개념이다.
- 로깅, 감사, 선언적 트랜잭션, 보안, 캐싱 등 다양한 곳에서 사용되고 있다.
> ? 사용처는 추가로 학습해야하는 부분 (저 분야에서 어떻게 사용되지 ?)

- 스프링 AOP에서 특정 메소드 “호출”을 관심사로 설정하여 해당 메소드 호출시 자동으로 다른 메소드가 호출될 수 있도록 할 수 있다. (메소드 호출 전후로 모듈 삽입)

### 스프링 AOP 용어
- Joint Point : 모듈이 삽입되어 동작하게 되는 특정 위치 -> 관심사 (메소드 호출 등)
- Point Cut : 다양한 Joint Point (관심사) 중에서 어떤 것을 사용할지 선택
- Advice : Joint Point 에 삽입되어 동작할 수 있는 코드 (삽입되는 모듈)
- Weaving : Advice 를 핵심 로직 코드에 적용하는 것
- Aspect : Point Cut + Advice

### 스프링 AOP Advice 의 종류
- before : 메소드 호출 전에 동작하는 Advice
- after-returning : 호출된 메소드 동작이 예외(Exception) 발생 없이 완료되면 동작하는 Advice
- after-throwing : 호출된 메소드 동작 중 예외가 발생했을 때 동작하는 Advice
- after : 예외 발생 여부와 무관하게 호출된 메소드 동작이 완료되면 동작하는 Advice
- around : 메소드 호출 전후 동작하는 Advice
