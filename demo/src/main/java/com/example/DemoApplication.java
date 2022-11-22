package com.example;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.entities.Actor;
import com.example.domains.entities.dtos.ActorDTO;
import com.example.domains.entities.dtos.ActorShort;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		// ...
	}

	@Autowired
	ActorRepository dao;

	@Override
	@Transactional
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
//		dao.findTop5ByFirstNameStartingWithOrderByLastNameDesc("P").forEach(System.out::println);
//		dao.findTop5ByFirstNameStartingWith("P", Sort.by("actorId").descending()).forEach(System.out::println);
//		dao.findByActorIdGreaterThan(200).forEach(System.out::println);
//		dao.findNovedadesJPQL(200).forEach(System.out::println);
//		dao.findNovedadesSQL(200).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.lessThanOrEqualTo(root.get("actorId"), 5)).forEach(System.out::println);
//		var item = dao.findById(1);
//		if(item.isPresent()) {
//			var actor = item.get();
//			System.out.println(actor);
//			actor.getFilmActors().forEach(p -> System.out.println(p.getFilm().getTitle()));
//		} else {
//			System.out.println("No encontrado");
//		}
//		var entrada = new ActorDTO(0, null, null);
//		var actor =  ActorDTO.from(entrada); //new Actor(0, null, null);
//		if (actor.isValid()) {
//			dao.save(actor);
//			dao.findAll().forEach(System.out::println);
//		} else {
//			System.err.println(actor.getErrorsMessage());
//		}
//		dao.findNovedadesSQL(200).forEach(p -> System.out.println(ActorDTO.from(p)));
//		dao.getByActorIdGreaterThan(200).forEach(System.out::println);
//		dao.readByActorIdGreaterThan(200).forEach(p -> System.out.println(p.getActorId() + " " + p.getNombre()));
		dao.findAllBy(ActorDTO.class).forEach(System.out::println);
		dao.findAllBy(ActorShort.class).forEach(p -> System.out.println(p.getActorId() + " " + p.getNombre()));
	}

}
