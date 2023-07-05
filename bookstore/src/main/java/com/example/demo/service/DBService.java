package com.example.demo.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Livro;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.LivroRepository;

@Service
public class DBService {
	
	private CategoriaRepository categoriaRepository;
	private LivroRepository livroRepository;
	
	public DBService(CategoriaRepository categoriaRepository, LivroRepository livroRepository) {
		this.categoriaRepository = categoriaRepository;
		this.livroRepository = livroRepository;
	}

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informarica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Matematica", "Livros de matematica");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Calculo I", "Robert", "Lorem ipsum", cat2);
		Livro l3 = new Livro(null, "Calculo Numerico", "Edson", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "Programacao em C", "Ewerton", "Lorem ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		cat2.getLivros().addAll(Arrays.asList(l2));
		cat2.getLivros().addAll(Arrays.asList(l3));
		cat1.getLivros().addAll(Arrays.asList(l4));
		
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
		
	}
	
	
}
