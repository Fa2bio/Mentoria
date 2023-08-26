package org.edu.unidep.domain.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.lang3.StringUtils;
import org.edu.unidep.domain.exception.CepInvalidoException;
import org.edu.unidep.domain.exception.EnderecoNaoEncontradoException;
import org.edu.unidep.domain.model.Endereco;

import com.google.gson.Gson;

@ApplicationScoped
public class EnderecoService {
	
	public Endereco enderecoViaCep(String cep) {
		try {
			validarCep(cep);
			URL url = new URL(String.format("https://viacep.com.br/ws/%s/json/", cep));
			URLConnection connection = url.openConnection();
			InputStream input = connection.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(input,"UTF-8"));
			StringBuilder jsonCep = new StringBuilder();
			
			String laco;
			while((laco = buffer.readLine())!=null) {
				jsonCep.append(laco);
			}
			
			Gson gson = new Gson();
			Endereco endereco = gson.fromJson(jsonCep.toString(), Endereco.class);
			if(endereco.getCep() == null) {
				throw new EnderecoNaoEncontradoException(cep);
			}
			
			return endereco;
			
		} catch (MalformedURLException e) {
			throw new EnderecoNaoEncontradoException(cep);
		} catch(IOException e) {
			throw new EnderecoNaoEncontradoException(cep);
		}
	}

	private boolean validarCep(String cep) {
		if(cep.contains("-")) {
			if(cep.length() == 9) {
				cep.replace("-", "");
				return true;
			}else throw new CepInvalidoException("Formato inválido. CEP contem '-' e possiu mais/menos de 9 caracteres");
		}else if(cep.length() != 8) {
			throw new CepInvalidoException("Formato inválido. CEP mais/menos de 8 caracteres");
		}else if(!StringUtils.isNumeric(cep)) {
			throw new CepInvalidoException("Formato inválido. CEP contém caracteres [a-z][A-Z] e/ou espaços entre os digitos");
		}else return true;
	}
}
