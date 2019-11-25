package kr.co.spring.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = { "kr.co.spring.beans", "kr.co.spring.db" })
public class BeanConfiguration {

	// dataSource 객체를 생성하고 반환하는 빈 등록
	// 외부 jar 파일 사용하는 빈은 @Bean 으로, 직접 작성한 클래스는 @Component 로 빈 등록
	@Bean
	public BasicDataSource dataSource() {
		// DataSource : 접속 정보를 가진 객체 (DBCP 사용)
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring?useSSL=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("12345678");

		// dataSource 리턴
		return dataSource;

	}

	// 데이터베이스에 접속해서 쿼리를 전달하는 빈 등록
	@Bean
	public JdbcTemplate dbConnection(BasicDataSource dataSource) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		return template;

	}
}
