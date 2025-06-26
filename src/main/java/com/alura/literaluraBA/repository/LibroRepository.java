package com.alura.literaluraBA.repository;

import com.alura.literaluraBA.model.LibroClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<LibroClass, Long> {
    Optional<LibroClass> findByTituloContainsIgnoreCase(String nombreLibroBuscado);

    @Query("SELECT l FROM LibroClass l WHERE l.idioma = :enviarIdioma")
    List<LibroClass> findByIdioma(String enviarIdioma);
}
