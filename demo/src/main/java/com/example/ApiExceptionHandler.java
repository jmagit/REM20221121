package com.example;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.exceptions.BadRequestException;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

import java.io.Serializable;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class ApiExceptionHandler {
	public static class ErrorMessage implements Serializable {
		private static final long serialVersionUID = 1L;
		private String error, message;

		public ErrorMessage(String error, String message) {
			this.error = error;
			this.message = message;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ NotFoundException.class, EmptyResultDataAccessException.class })
	public ErrorMessage notFoundRequest(Exception exception) {
		return new ErrorMessage("Not found",
				ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ BadRequestException.class, DuplicateKeyException.class })
	public ErrorMessage badRequest(Exception exception) {
		return new ErrorMessage(exception.getMessage(), "");
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ InvalidDataException.class, MethodArgumentNotValidException.class })
	public ErrorMessage invalidData(Exception exception) {
		return new ErrorMessage("Invalid data", exception.getMessage());
	}

	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	public ErrorMessage methodNotSupported(Exception exception) {
		return new ErrorMessage(exception.getMessage(), "");
	}
}
