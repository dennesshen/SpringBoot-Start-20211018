package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entity.one2one.Card;
import com.example.demo.entity.one2one.Husband;
import com.example.demo.entity.one2one.Person;
import com.example.demo.entity.one2one.Wife;
import com.example.demo.repository.HusbandRespository;
import com.example.demo.repository.PersonRespository;

@SpringBootApplication
public class One2OneJPATest2 {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(One2OneJPATest2.class, args);
		PersonRespository personRespository = context.getBean(PersonRespository.class);
		
		Card card = new Card();
		card.setNumberString("T124145612");
		
		Person person = new Person();
		person.setName("Helen");
		person.setCard(card);
		
		personRespository.save(person);

	}

}
