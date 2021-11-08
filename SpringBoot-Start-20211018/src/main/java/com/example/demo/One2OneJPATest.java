package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entity.one2one.Husband;
import com.example.demo.entity.one2one.Wife;
import com.example.demo.repository.HusbandRespository;

@SpringBootApplication
public class One2OneJPATest {
	static ApplicationContext context;
	static HusbandRespository husbandRespository;
	public static void main(String[] args) {
		context = SpringApplication.run(One2OneJPATest.class, args);
		husbandRespository = context.getBean(HusbandRespository.class);
		
		
		
		//新增
		//add();
		
		//查詢全部query
		//query();
		
		//查詢單筆byId
		//findOne(1L);
		//findOne(999L);
		
		//查詢單筆byName
		findByName("John");
		
	}
	
	public static void findByName(String name) {
		Husband opt = husbandRespository.findByName(name);
		if (opt != null) {
			System.out.println(opt);
		}else {
			System.out.println("not found");
		}

	}
	
	public static void findOne(Long id) {
		Optional<Husband> opt = husbandRespository.findById(id);
		if (opt.isPresent()) {
			System.out.println(opt.get());
		}else {
			System.out.println("Not found");
		}
	}
	
	public static void query() {
		List<Husband> husbands = husbandRespository.findAll();
		for(Husband husband : husbands) {
			System.out.println(husband);
			System.out.println(husband.getWife().getName());
			System.out.println(husband.getWife().getHusband().getName());
		}
		
	}
	
	
	public static void add() {
		Wife wife = new Wife();
		wife.setName("Mary");
		
		Husband husband = new Husband();
		husband.setName("John");
		husband.setWife(wife);
		
		husbandRespository.save(husband);
		
		System.out.println(husband);
		System.out.println(wife);
	}

}
