package kr.co.spring.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.co.spring.mapper.MapperInterface;

@Configuration
@ComponentScan(basePackages= {"kr.co.spring.beans"})
public class BeanConfiguration {

	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring?useSSL=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("12345678");
		
		return dataSource;
	}
	
	// SqlSessionFactory : Jdbc 처리 객체 사용
	@Bean
	public SqlSessionFactory sqlSession(BasicDataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionBean =  new SqlSessionFactoryBean();
		sqlSessionBean.setDataSource(dataSource);
		
		SqlSessionFactory sqlSession = sqlSessionBean.getObject();
		return sqlSession;
	}
	
	// MapperInterFace 를 Bean 으로 등록한다.
	@Bean
	public MapperFactoryBean<MapperInterface> testMapper(SqlSessionFactory sqlSession) {
		
		MapperFactoryBean<MapperInterface> mapperBean = new MapperFactoryBean<MapperInterface>(MapperInterface.class);
		mapperBean.setSqlSessionFactory(sqlSession);
		
		return mapperBean;
	}
	
}
