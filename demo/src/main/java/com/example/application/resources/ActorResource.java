package com.example.application.resources;

import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.exceptions.BadRequestException;
import com.example.exceptions.NotFoundException;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/actores")
public class ActorResource {
	@Autowired
	private ActorRepository dao;

	@Autowired
	private Validator validator;

	@GetMapping
	public List<Actor> getAll() {
		// …
	}

	@GetMapping(path = "/{id}")
	public Actor getOne(@PathVariable int id) throws NotFoundException {
		// …
	}
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody Actor item) throws BadRequestException {
		// …
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(newItem.getActorId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable int id, @Valid @RequestBody Actor item) throws BadRequestException, NotFoundException {
		// …
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		// ..
	}
}

