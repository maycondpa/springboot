package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Endereco;
import com.example.demo.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	private final String url = "https://viacep.com.br/ws/";

	public String buscarCep(@PathVariable("cep") Long cep) {

		try {
			RestTemplate restTemplate = new RestTemplate();
			Endereco response = restTemplate.getForObject(url + cep + "/json", Endereco.class);
			if (response.getCep() == null) {
				return "<h2> Este cep não trás informações. </h2>";

			} else {
				return response.toString();
			}

		} catch (Exception ex) {

			return "<h2> Cep Inexistente: </h2>";
		}
	}

	public String addEndereco(@PathVariable("cep") String cep) {
		try {
			RestTemplate template = new RestTemplate();
			Endereco response = template.getForObject(url + cep + "/json/", Endereco.class);
			if (response.getCep() == null) {
				return "<h2> Este cep não trás informações. </h2>";
			} else {
				enderecoRepository.save(response);
				return "<h2> Registro Salvo. </h2>";
			}

		} catch (Exception ex) {
			return "<h2> Cep já existe no banco.";
		}
	}

	public List<Endereco> listarTodos() {
		return enderecoRepository.findAll();
	}

	public String deleteEndereco(@PathVariable("id") Long id) {
		try {
			enderecoRepository.delete(id);
			return "<h2> O registro foi removido do banco. </h2>";

		} catch (Exception ex) {

			return "<h2> ID não encontrado no Banco. </h2>";
		}
	}

	public Endereco selectEnderecoId(@PathVariable("id") Long id) {
		return enderecoRepository.findOne(id);
	}

	public List<Endereco> selectEnderecobairro(@PathVariable("bairro") String bairro) {
		return enderecoRepository.findByBairro(bairro);

	}

}
