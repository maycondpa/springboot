package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Endereco;
import com.example.demo.service.EnderecoService;

@RestController
@RequestMapping("/address")
public class viaCepController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping("/{cep}")
	public String buscar(@PathVariable("cep") Long cep) {
		return enderecoService.buscarCep(cep);
	}

	@GetMapping(path = "/add/{cep}")
	public String addEndereco(@PathVariable("cep") String cep) {
		return enderecoService.addEndereco(cep);
	}

	@GetMapping(path = "/findAll")
	public List<Endereco> findAll() {
		return enderecoService.listarTodos();
	}

	@GetMapping(path = "/delete/{id}")
	public String deleteEndereco(@PathVariable("id") Long id) {
		return enderecoService.deleteEndereco(id);
	}

	@GetMapping(path = "/select/{id}")
	public Endereco selectEnderecoId(@PathVariable("id") Long id) {
		return enderecoService.selectEnderecoId(id);
	}

	@GetMapping(path = "/selected/{bairro}")
	public List<Endereco> selectEnderecobairro(@PathVariable("bairro") String bairro) {
		return enderecoService.selectEnderecobairro(bairro);
	}

}
