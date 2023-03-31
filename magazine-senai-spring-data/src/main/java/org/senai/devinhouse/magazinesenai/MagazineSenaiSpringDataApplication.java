package org.senai.devinhouse.magazinesenai;

import org.senai.devinhouse.magazinesenai.models.Produto;
import org.senai.devinhouse.magazinesenai.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MagazineSenaiSpringDataApplication implements CommandLineRunner {
	@Autowired private ProdutoService service;

	public static void main(String[] args) {
		SpringApplication.run(MagazineSenaiSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite um nome de produto:");
		String nome = scanner.nextLine();

		System.out.println("Digite uma descrição do produto:");
		String descricao = scanner.nextLine();

		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setPreco(100);

		service.salvar(produto);
	}
}
