package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entity.one2many.Magazine;
import com.example.demo.entity.one2many.Page;
import com.example.demo.repository.MagazineRespository;
import com.example.demo.repository.PageRespository;

@SpringBootApplication
public class One2ManyJPATest {
	static ApplicationContext context;
	static MagazineRespository magazineRespository;
	static PageRespository pageRespository;

	public static void main(String[] args) {
		context = SpringApplication.run(One2ManyJPATest.class, args);
		magazineRespository = context.getBean(MagazineRespository.class);
		pageRespository = context.getBean(PageRespository.class);
		
		add();
		
	}
	/*
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
	*/
	
	public static void add() {
		Magazine magazine = new Magazine();
		magazine.setTitle("Python");
		//save magazine
		magazineRespository.save(magazine);
		
		//create and save new page 
		Page p1 = new Page(10, "catalog", magazine);
		Page p2 = new Page(20, "basic", magazine);
		Page p3 = new Page(30, "object", magazine);
		Page p4 = new Page(40, "Thread", magazine);
		Page p5 = new Page(50, "IO", magazine);

		pageRespository.save(p1);
		pageRespository.save(p2);
		pageRespository.save(p3);
		pageRespository.save(p4);
		pageRespository.save(p5);
		
	}

}
