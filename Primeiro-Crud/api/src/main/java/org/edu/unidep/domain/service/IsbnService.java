package org.edu.unidep.domain.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.edu.unidep.domain.exception.IsbnInvalidoException;
import org.edu.unidep.domain.exception.IsbnNaoEncontradoException;
import org.edu.unidep.domain.model.VolumeInfo;
import org.edu.unidep.domain.orm.IsbnInputModel;
import org.edu.unidep.domain.orm.LivroInfo;

import com.google.gson.Gson;

@ApplicationScoped
public class IsbnService {

	public VolumeInfo gerarVolumeInfo(String isbn) {
		try {
			isbnValidator(isbn);
			URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:"+isbn);
			URLConnection connection = url.openConnection();
			InputStream input = connection.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(input,"UTF-8"));
			StringBuilder jsonIsbn = new StringBuilder();
			
			String laco;
			while((laco = buffer.readLine())!=null) {
				jsonIsbn.append(laco);
			}
			
			Gson gson = new Gson();
			System.out.println(jsonIsbn.toString());
			IsbnInputModel isbnFromJson = gson.fromJson(jsonIsbn.toString(), IsbnInputModel.class);
			
			if(isbnFromJson.getItens() == null) {
				throw new IsbnNaoEncontradoException(String.format("Não há livro com o isbn: %s", isbn));
			}
			
			return volumeInfoAssembler(isbnFromJson.getItens());
			
		} catch (MalformedURLException e) {
			throw new IsbnNaoEncontradoException(isbn);
		} catch(IOException e) {
			throw new IsbnNaoEncontradoException(isbn);
		}
	}
	
	private VolumeInfo volumeInfoAssembler(List<LivroInfo> itens) {
		VolumeInfo volumeInfo = new VolumeInfo();
		itens.forEach(e -> {
			
			volumeInfo.setTitulo(e.getVolumeInfo().getTitle());
			volumeInfo.setDataPublicacao(e.getVolumeInfo().getPublishedDate());
			volumeInfo.setDescricao(e.getVolumeInfo().getDescription());
			volumeInfo.setLingua(e.getVolumeInfo().getLanguage());
			volumeInfo.setQtdPags(e.getVolumeInfo().getPageCount());
			
			e.getVolumeInfo().getIndustryIdentifiers().forEach(f->{
				if(f.getType().equalsIgnoreCase("isbn_10")) volumeInfo.setIsbn10(f.getIdentifier());
				else volumeInfo.setIsbn13(f.getIdentifier());
			});
			
			volumeInfo.setAutores(e.getVolumeInfo().getAuthors());
			
		});
		
		return volumeInfo;
	}
	
	public String isbnValidator(String isbn) {
		if(isbn.contains("-")) {
			if(isbn.length()==14) {
				isbn = isbn.replace("-", "");
				return isbn;
			}else {
				throw new IsbnInvalidoException("Isbn deve ser do tipo isbn-10 ou isbn-13");
			}
		}else if((isbn.length() == 10) || (isbn.length() == 13)) return isbn;
		else throw new IsbnInvalidoException("Isbn deve ser do tipo isbn-10 ou isbn-13");
	}
}
