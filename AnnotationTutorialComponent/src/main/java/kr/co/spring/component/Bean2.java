package kr.co.spring.component;

import org.springframework.stereotype.Component;

// 이 클래스를 bean 으로 등록하고, bean 의 이름은 beanName 으로 한다.
// * 한계점 : @Componenet 어노테이션으로는 한 클래스에 대해 1 개의 bean 만 등록 가능하다.
//          2 개 이상의 bean 등록을 하려면, xml 혹은 @Configuration 파일에서 직접 정의해야 한다.
@Component("beanName")
public class Bean2 {

}
