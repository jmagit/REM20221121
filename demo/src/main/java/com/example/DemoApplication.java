package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.entities.Actor;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		// ...
	}

	@Autowired
	ActorRepository dao;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicacion arracada");
//		var actor = new Actor(217, "NUEVO", "actor");
//		dao.save(actor);
//		var item = dao.findById(217);
//		if(item.isPresent()) {
//			var actor = item.get();
//			actor.setLastName(actor.getLastName().toUpperCase());
//			dao.save(actor);
//			dao.findAll().forEach(System.out::println);
//		} else {
//			System.out.println("No encontrado");
//		}
//		dao.deleteById(218);
//		dao.findAll().forEach(System.out::println);
	}

}
