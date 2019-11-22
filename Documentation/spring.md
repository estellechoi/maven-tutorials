# 스프링 프레임워크(Spring) 사용하기
  > 이 문서는 인프런의 '스프링 프레임워크 개발자를 위한 실습을 통한 입문 과정'강의를 참고하여 작성하였다.
  > 메이븐 설정파일 pom.xml 을 통해 스프링(Spring) 라이브러리를 다운로드하자 !
  > 스프링 프레임워크 사용시 Java ver 8 (1.8) 권장된다.
  > 현재 스프링 프레임워크는 버전 4, 5 사용이 권장된다.

### 스프링 프레임워크(Spring) 사용을 위한 라이브러리 다운로드
  - 메이븐 설정파일(pom.xml)에서 \<dependency\> 태그 추가를 통해 다운로드한다.
  - spring-context 라이브러리를 다운로드하는 태그를 작성하는데, 이를 위한 코드는 [MVNRepository](https://mvnrepository.com/) 에서 \'spring-context\' 로 검색하여 사용할 버전의 코드를 복사해오면 된다 ! `ctrl+c ctrl+v`

### IoC (Inversion of Control, 제어 역전)
- 일반적으로 프로그래밍을 작성할 때 프로그램이 흘러가는 흐름이나 생성되는 객체에 대한 제어권을 개발자가 가지는 것과 달리, 프레임워크가 가지는 것을 의미한다.
- 개발자가 코드의 흐름이나 객체 생성에 관련된 코드를 프로그래밍 코드에 직접 작성하는 것이 아닌, 프레임워크 설정 파일에 설정한 것을 토대로 프레임워크가 객체를 생성, 반환하고 코드가 동작하는 순서를 결정한다.

### POJO Class (Plain Old Java Object)
- 자바 모델이나 기능, 프레임워크 등에 따르지 않고 홀로 독립적이며 단순한 기능만을 가진 객체
- 자바에서는 이러한 객체들을 Bean 이라고 한다.
- DAO 객체 등도 포함된다.

### 스프링 프레임워크의 IoC 컨테이너
- IoC 컨테이너에서는 xml 또는 자바 파일에서 설정한 정보(metadata) 를 토대로, 자바 POJO 클래스를 객체로 생성하고 반환한다.

### Xml 파일(bean configuration file)로 Bean 정의하기
- \.xml
- \<bean id\=\“빈 아이디\” class\=\“참조 클래스\”\/\> 태그로 사용할 Bean 설정
-  \<bean\/\> 의 속성
	- class : 사용할 클래스
	- id : bean 의 주소값을 호출할 때 필요한 아이디
	- lazy-init : 싱글톤인 경우, xml 로딩시 객체 자동생성 여부를 설정하는 속성
		- true : 객체를 미리 생성하지 않고, 객체 호출시(getBean()) 객체 한 번 생성
		- false : xml 로딩시 객체 자동 생성 (디폴트)
	- scope : 객체의 범위 설정
		- singletone : 객체를 하나만 생성해서 사용 (디폴트)
		- prototype : 객체를 호출할 때마다 객체 생성 (xml 로딩시 객체 생성 X)
	- init-method : 생성자 호출 직후 자동으로 호출될 메소드를 설정하는 속성
	- destroy-method : 객체 소멸시 자동으로 호줄될 메소드를 설정하는 속성
	- default-init-method : init-method 미설정시 자동으로 호출될 메소드를 설정하는 속성
	- default-destroy-method : destroy-method 미설정시 자동으로 호출될 메소드를 설정하는 속성

### Bean 객체의 생명주기
 - IoC 컨테이너가 종료될 때 Bean 객체도 소멸되다. (ctx\.close())

### BeanPostProcessor
- bean 객체를 정의할 때, init-method 속성을 설정하면 bean 객체 생성시 자동으로 호출될 메소드를 설정할 수 있다.
- 이 때 BeanPostProcessor 인터페이스를 구현한 클래스를 정의하면, bean 객체 생성시 호출될 init 메소드 호출을 가로채 다른 메소드를 호출할 수 있도록 할 수 있다.
- postProcessBeforeInitialization : init-method 지정 메소드가 호출되기 전에 호출된다.
- postProcessAfterInitialization : init-method 지정 메소드가 호출된 후 호출된다.
- init-method 미지정시에도 호출된다.

### IoC 컨테이너의 종류
- BeanFactory
- ApplicationContext
- 사용하는 스프링 버전에 따라 사용하는 것이 다르다.

### BeanFactory
- 클래스를 객체로 생성하고 이를 전달한다. (Bean의 주소값 반환)
- 상속 등 객체간 관계를 형성하고 관리한다.
- xml 파일에서 설정한 정보(Bean 설정)은 즉시 로딩하지만, 객체는 개발자가 요구할 때 생성한다.
- XmlBeanFactory

### ApplicationContext
- 클래스를 객체로 생성하고 이를 전달한다. (Bean의 주소값 반환)
- 상속 등 객체간 관계를 형성하고 관리한다.
- 국제화를 지원한다. (문자열 관련 다양한 기능 제공)
- 리스너로 등록된 Bean 에 이벤트를 발생시킬 수 있다.
- xml 파일에서 설정한 정보(Bean 설정)를 즉시 로딩하고 객체를 미리 생성해서 가지고 있다.
- ClassPathXmlApplicationContext
- FileSystemXmlApplicationContext
- XmlWebApplicationContext

### DI (Dependency Injection, 의존성 주입)
- bean 객체를 생성할 때 bean 객체가 관리할 값이나 객체를 주입하는 것을 의미한다.
- bean 을 정의하는 xml 파일에서 정의하는 개념이다.
- constructor\-arg : 생성자를 통한 의존성 주입
- property : setter 를 통한 의존성 주입
- 컬렉션 주입
	- bean 정의시 주입해야 하는 멤버가 컬렉션 타입인 경우, 컬렉션이 관리할 객체를 초기에 설정할 수 있다.
	- List, Map, Set, Property

### Xml 파일에서 Bean 자동 주입 설정하기
- bean 을 정의할 때 주입할 객체는 생성자 또는 setter 메소드를 통해 주입하였다.
- 스프링에서는 객체를 자동을 주입되도록 설정할 수 있다. (Auto wire)
- 자동 주입은 이름, 타입, 생성자를 통할 수 있다.
- autowire\=\“byName\” : 주입 대상인 bean 객체의 프로퍼티 이름(변수명)과 정의된 bean 의 id 가 동일한 것을 찾아 자동 주입
- autowire\=\“byType\” : 정의된 bean 중에서 타입이 일치하는 것을 찾아 자동 주입
	- 동일 타입의 bean 이 2 개 이상 정의되어 있으면 오류 발생

- autowire\=\“constructor\” : 생성자의 매개변수와 타입이 일치하는 것을 찾아 자동 주입 (클래스타입만 해당 \/ int, String X )
- autowire\=\“no\” : default-autowire 를 포함하여, 자동주입을 사용하지 않기

### 어노테이션(Annotation)으로 Bean 정의하기 \- \@Configuration 파일
- \@Configuration : 현재 자바 파일은 bean 등록을 위한 자바 파일이다.
- \@Bean : bean 을 정의한다. 메소드의 이름이 bean의 이름이 된다.
- \@Bean\(name\=\“name\”\) : bean의 이름을 새롭게 정의한다.
- \@Bean\(initMethod\=\“메소드명\”, destroyMethod\=\“메소드명\”\) : init/destroy 메소드를 지정한다.
- \@Bean(autowire\=\“주입방식\”) : 자동주입 (스프링 5.1 부터 deprecated)
	- autowire \= Autowire\.BY\_NAME
	- autowire \= Autowire\.BY\_TYPE
- \@Lazy : lazy-init 속성을 지정한다. (Ture/false)
- \@Scope : scope 속성을 지정한다. (Singletone/prototype)
- \@Primary : primary 속성을 지정한다.

### 어노테이션(Annotation)으로 Bean 정의하기 \- 클래스 파일 (\.java)
- 클래스 파일에서 \@Component 사용하려면 아래와 같이 명시해야 한다.
	- xml : \<context:component-scan base-package\=\“경로\” \/\>
	- \@Configuratoin : \@ComponentScan(basePackages\=\{\“경로\”, \”경로\”\})
- \@Component : \@Configuration 파일에서 \@Bean 정의하지 않아도, bean 으로 자동 정의된다.

### \@Bean 과 \@Component, 무엇을 사용할까 ?
- \@Bean
	- 개발자가 클래스 파일의 코드를 수정할 수 없는 경우 -> \@Component 텍스트 자체를 코딩할 수 없으므로
	- 같은 클래스 타입의 bean 을 여러개 등록하는 경우 -> \@Component 로는 1 개의 bean 만 등록할 수 있으므로
- \@Component
	- 개발자가 클래스 파일의 코드를 수정할 수 있는 경우

### 어노테이션(Annotation)으로 Bean 주입하기 \- 클래스 파일 (\.java)
-  클래스 파일에서 어노테이션을 사용하려면 xml 에 \<context:annotation-config \/\> 명시해야 한다.
- \@Bean, \@Component 로 등록한 Bean 을 주입할 때 동일하게 적용된다.
- @Required : 반드시 주입해야 할 프로퍼티로 설정한다. (Spring 5.1 부터 deprecated \-\> 필수 프로퍼티는 생성자를 이용하도록 변경)
- Setter() 메소드를 통한 주입
	- \@Autowired : 타입이 같은 bean 객체를 자동 주입한다. (setter()를 통한 주입)
	- \@Qualifier(\“name\”) : 타입이 같은 bean이 2 개 이상 존재하는 경우, 이름을 명시하여 자동 주입한다.
- 생성자를 통한 주입
	- 생성자의 매개변수와 같은 클래스 타입의 bean 이 존재한다면 \@Autowired 어노테이션 없이 자동 주입된다.

### Javax Annotation API (JSR-250 대체)
- 스프링에서 기본으로 제공되지 않지만, 자바 플랫폼 공통 어노테이션인 JSR-250을 적용할 수 있다.
- pom.xml 파일에서 별도로 Javax Annotation 라이브러리를 추가해야 한다.
- Init/Destroy Method
	- \@PostConstruct : 생성자 호출 후 자동 호출될 함수로 등록한다. (Init-method)
	- \@PreDestroy : 객체 소멸 전 자동으로 호출될 함수로 등록한다.
- Setter() 메소드를 통한 자동주입
	- \@Resource : 객체 이름을 통해 bean 객체를 자동 주입한다. (Autowired \+ Qualifier)
	- \@Resource(name\=\“name\”) : 이름이 다른 bean 객체를 자동주입 설정하기 위해 주입할 bean 의 이름을 별도로 명시한다.

### Redirect
- 지금의 페이지에서 특정 페이지로 전환하는 기능
return \"redirect\:\/\"\;

### Interceptor
- redirect 를 빈번하게 사용해야하는 경우, HandlerInterceptor 인터페이스를 이용한다.
* 3가지
      * preHandle() : Controller 작업 전
      * postHandle() : Controller 작업 후
      * afterCompletion() : 뷰 작업 후
 * HandlerInterceptorAdapter 클래스 상속을 통해 사용 (스프링 제공)
 *
