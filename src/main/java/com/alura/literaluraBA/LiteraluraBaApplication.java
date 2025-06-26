package com.alura.literaluraBA;

import com.alura.literaluraBA.principal.Principal;
import com.alura.literaluraBA.repository.AutorRepository;
import com.alura.literaluraBA.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraBaApplication implements CommandLineRunner {

	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private LibroRepository libroRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraBaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Principal principal = new Principal(libroRepository, autorRepository);
		principal.muestraMenu();
	}

}
