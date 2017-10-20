package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	List<Endereco> findByBairro(String bairro);
	
}
