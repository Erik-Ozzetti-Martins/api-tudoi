package com.erik.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.erik.todo.domain.Tudo;

@Repository
public interface TudoRepository extends JpaRepository<Tudo, Integer> {

	@Query("Select obj FROM Tudo obj where obj.finalizado=false ORDER BY obj.dataParaFinalizar")
	List<Tudo> findAllOpen();

	@Query("Select obj FROM Tudo obj where obj.finalizado=true ORDER BY obj.dataParaFinalizar")
	List<Tudo> findAllClose();

	

}
