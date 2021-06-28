package com.erik.todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.erik.todo.domain.Tudo;
import com.erik.todo.repositories.TudoRepository;

@SpringBootApplication
public class Todo1Application implements CommandLineRunner{
	
	

	public static void main(String[] args) {
		SpringApplication.run(Todo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
