package com.alura.literaluraBA.repository;

import com.alura.literaluraBA.model.AutorClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<AutorClass, Long> {

    @Query("SELECT a FROM AutorClass a WHERE a.nombreAutor = :nombreAutor ")
    AutorClass findByNombre(String nombreAutor);

    @Query("SELECT a FROM AutorClass a WHERE :anio between a.fechaNacimiento AND a.fechaFallecimiento")
    List<AutorClass> findByYear(int anio);
}
