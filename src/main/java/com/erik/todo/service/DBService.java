package com.erik.todo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erik.todo.domain.Tudo;
import com.erik.todo.repositories.TudoRepository;

@Service
public class DBService {
	@Autowired
	private TudoRepository tudoRepository;

	public void instanciaBaseDeDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Tudo t1 = new Tudo(null, "Estudar ", "Estudar Spring boot 2 e angular 11",
				sdf.parse("17/05/2022"), false);
		Tudo t2 = new Tudo(null, "Estudar 2 ", "Estudar Spring boot 2.3 e angular 12",
				sdf.parse("17/02/2022"), false);
		Tudo t3 = new Tudo(null, "Estudar 3 ", "Estudar Spring boot 2 e angular 11.0",
				sdf.parse("17/08/2022"), true);
		Tudo t4 = new Tudo(null, "Estudar 4", "Estudar Spring boot 2 e angular 12.0.1",
				sdf.parse("17/09/2022"), true);
		
		tudoRepository.saveAll(Arrays.asList(t1,t2,t3,t4));
	}

}
