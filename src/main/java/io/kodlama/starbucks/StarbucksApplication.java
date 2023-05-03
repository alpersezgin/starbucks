package io.kodlama.starbucks;

import io.kodlama.starbucks.core.utilities.exceptions.ExceptionResponse;
import io.kodlama.starbucks.core.utilities.exceptions.business.BusinessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestControllerAdvice
public class StarbucksApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarbucksApplication.class, args);
	}

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ExceptionResponse handleBusinessException(BusinessException businessException){
		return new ExceptionResponse(
				businessException.getErrorCode().getCode(),
				businessException.getMessage()
		);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ExceptionResponse handleValidationException(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage)
				.toList();

		return new ExceptionResponse(
				400,
				"Validation errors:\n" + errors.stream().map(s -> "\t" + s).collect(Collectors.joining(",\n"))
		);
	}

}
