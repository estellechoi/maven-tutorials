# 스프링(Spring) 전에 메이븐(Maven)이 있다 !
  > 스프링을 배우면서 같이 듣게되는 메이븐, 그런데 왜 아무도 메이븐이 뭔지 설명해주지 않을까? 궁금해하다가 구글링을 통해 메이븐이 무엇인지 정도만 공부해 보았다.
  > 메이븐 설정파일 pom.xml 을 통해 스프링(Spring) 라이브러리를 다운로드하고, 스프링에서 제공하는 기능들을 사용하여 자바 기반 프로젝트를 수월하게 작성할 수 있다. 

### 1. 메이븐(Maven) 이란 ?
  - 메이븐은 프로젝트의 라이프 사이클을 관리하는 도구이다.
  - 자바 프로젝트의 빌드(build)를 자동화해준다.
  - 메이븐 설정파일 pom.xml 에서 사용할 라이브러리를 설정하면, 해당 라이브러리와 라이브러리가 의존하고 있는 다른 라이브러리들을 자동으로 다운받아준다.
  - 메이븐에서 제공하는 모든 기능은 플러그인(Plugin)을 기반으로 동작한다.
  - 플러그인(Plugin)에서 실행할 수 있는 기능을 골(Goal)이라 하고, 하나의 플러그인에는 여러 개의 골이 있을 수 있다.

### 2. 메이븐의 라이프 사이클(Life Cycle)
  - 메이븐에서 미리 정의한 빌드 순서를 라이프 사이클(Life Cycle)이라고 한다.
  - 라이프 사이클의 각 빌드 단계를 phase라고 한다.
  - 각 단계(Phase)는 의존 관계에 있기 때문에 이전 단계가 모두 수행되어야 다음 단계가 수행될 수 있다.
  - 각 단계는 하나의 골(Goal)과 연결되어 있고, 어떤 플러그인(Plugin)의 골(Goal)을 수행할지 설정한다.
  - 라이프 사이클
      - mvn process-resources : resources:resources의 실행으로 resource 디렉토리에 있는 내용을 target/classes로 복사
      - mvn compile : compiler:compile의 실행으로 src/java 밑의 모든 자바 소스를 컴파일해서 target/classes로 복사
      - mvn process-testResources, mvn test-compile : test/java의 내용을 target/test-classes로 복사
        (참고로 test만 mvn test 명령을 내리면 라이프사이클상 원본 소스로 컴파일된다.)
      - mvn test : surefire:test의 실행으로 target/test-classes에 있는 테스트케이스의 단위테스트를 진행
        (결과를 target/surefire-reports에 생성)
      - mvn package : target 디렉토리 하위에 jar, war, ear 등 패키지 파일을 생성, 이름은 <build>의 <finalName>의 값을 사용
        (지정되지 않았을 때는 "artifactId-version.extention" 이름으로 생성)
      - mvn install : 로컬 저장소로 배포
      - mvn deploy : 원격 저장소로 배포
      - mvn clean : 빌드 과정에서 생긴 target 디렉토리 내용 삭제
      - mvn site : target/site에 문서 사이트 생성
      - mvn site-deploy : 문서 사이트를 서버로 배포

### 3. 메이븐 설정파일 pom.xml
  - 자바 프로젝트를 생성 시 빌드 툴을 메이븐으로 설정했다면, 프로젝트 최상위 디렉토리에 pom.xml 파일이 생성된다.
  - pom.xml 은 POM(Project Object Model)을 설정하는 파일, 즉 프로젝트 내 빌드 옵션을 설정하는 파일이다.
  - \<project\> ... \<\/project\> 태그로 둘러싸여 있으며, 각 태그 내에서 빌드 옵션을 설정할 수 있다.
  - \<build\> ... \<\/build\> 내에서 메이븐의 핵심인 빌드 정보를 설정한다.
  - \<build\> 에서 설정할 수 있는 값들
      - \<finalName\> : 빌드 결과물(ex .jar) 이름 설정
      - \<resources\> : 리소스(각종 설정 파일)의 위치를 지정
      - \<resource\> : 없으면 기본으로 "src/main/resources"
      - \<testResources\> : 테스트 리소스의 위치를 지정
      - \<testResource\> : 없으면 기본으로 "src/test/resources"
      - \<Repositories\> : 빌드할 때 접근할 저장소의 위치를 지정, 기본값은 메이븐 중앙 저장소인 http://repo1.maven.org/maven2
      - \<outputDirectory\> : 컴파일한 결과물 위치 값 지정, 기본 "target/classes"
      - \<testOutputDirectory\> : 테스트 소스를 컴파일한 결과물 위치 값 지정, 기본 "target/test-classes"
      - \<plugin\> : 액션 하나를 담당하는 것으로 가장 중요하지만 들어가는 옵션은 제 각각, 따로 실행할 플러그인을 메이븐 명령어로 실행해야 함
      - \<executions\> : 플러그인 goal과 관련된 실행에 대한 설정
      - \<configuration\> : 플러그인에서 필요한 설정 값 지정



&#128519; 참고 사이트
  - (메이븐\(Maven\)은 알고 스프링\(Spring\)을 쓰는가? \(pom.xml 분석하며 가볍게 정리하는 빌드 툴, Maven\))[https://jeong-pro.tistory.com/168]
  - (\[Spring\] 메이븐\(Maven\)이란?)[https://jerryjerryjerry.tistory.com/63]
