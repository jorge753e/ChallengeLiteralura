package com.alura.literaluraBA.model;

import jakarta.persistence.*;

@Entity
@Table(name = "librosBD")
public class LibroClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorClass autor;

    private String idioma;
    private Integer totalDescargas;

    public LibroClass(){}

    public LibroClass(DatosLibro datosLibro, AutorClass autor){
        this.titulo = datosLibro.titulo();
        this.autor = autor;
        this.idioma = datosLibro.idioma().get(0);
        this.totalDescargas = datosLibro.totalDescargas();

    }



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public AutorClass getAutor() {
        return autor;
    }

    public void setAutor(AutorClass autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getTotalDescargas() {
        return totalDescargas;
    }

    public void setTotalDescargas(Integer totalDescargas) {
        this.totalDescargas = totalDescargas;
    }

    @Override
    public String toString() {
        return
                " Titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", idioma='" + idioma + '\'' +
                ", totalDescargas=" + totalDescargas ;
    }
}
