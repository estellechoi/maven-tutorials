package kr.co.spring.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.spring.beans.JdbcBean;
import kr.co.spring.config.BeanConfiguration;
import kr.co.spring.db.JdbcDao;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);

		// JdbcDao 빈 호출
		JdbcDao dao = ctx.getBean(JdbcDao.class);

		/*
		 * 데이터 입력 
		// JdbcBean 빈 객체 생성 및 setter() 로 값 주기
		JdbcBean bean1 = new JdbcBean();
		bean1.setNumber(1);
		bean1.setStr("hello");

		// JdbcDao.insertData() 메소드 호출
		dao.insertData(bean1);

		// JdbcBean 빈 객체 생성 및 setter() 로 값 주기
		JdbcBean bean2 = new JdbcBean();
		bean2.setNumber(2);
		bean2.setStr("hello2");

		// JdbcDao.insertData() 메소드 호출
		dao.insertData(bean2);
		
		
		// 저장 완료 출력 
		System.out.println("저장 완료");
		*/
		
		
		/* 데이터 수정 
		JdbcBean jdbcBean = new JdbcBean();
		jdbcBean.setNumber(2);
		jdbcBean.setStr("hello world");
		
		dao.updateData(jdbcBean);
		*/
		
		/* 데이터 삭제 */
		JdbcBean jdbcBean = new JdbcBean();
		jdbcBean.setNumber(1);
		
		dao.deleteData(jdbcBean);
		
		/* 데이터 조회 */
		List<JdbcBean> list = dao.selectData();
		
		for(JdbcBean jdbcBeanSelected : list) {
			System.out.printf("number : %d\n", jdbcBeanSelected.getNumber());
			System.out.printf("str : %s\n", jdbcBeanSelected.getStr());
			System.out.println("--------------------------------------");
		}
		
		// 컨테이너 종료 및 bean 소멸
		ctx.close();
	}

}
