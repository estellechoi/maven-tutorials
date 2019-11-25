package kr.co.spring.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.spring.beans.TestDto;
import kr.co.spring.config.BeanConfiguration;
import kr.co.spring.mapper.MapperInterface;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		// mapper 받아오기 
		MapperInterface mapper = ctx.getBean("testMapper", MapperInterface.class);
		
		// insert
		/*
		TestDto dto = new TestDto();
		dto.setNumber(1);
		dto.setStr("test myBatis");
		mapper.insertData(dto);

		TestDto dto2 = new TestDto();
		dto2.setNumber(3);
		dto2.setStr("keep going");
		mapper.insertData(dto2);
		*/
		
		// update
		TestDto dto = new TestDto();
		dto.setNumber(1);
		dto.setStr("test myBatis Update");
		mapper.updateData(dto);
		
		// delete
		mapper.deleteData(1);
		
		// select
		List<TestDto> list = mapper.selectData();
		for (TestDto dtoSelected : list) {
			System.out.printf("dto.number : %d\n", dtoSelected.getNumber());
			System.out.printf("dto.str : %s\n", dtoSelected.getStr());
			System.out.println("-----------------------------------------------");
		}
		
		
		
		ctx.close();
	}

}
