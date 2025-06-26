package com.alura.literaluraBA.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autoresBD")
public class AutorClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombreAutor;
    private Integer fechaNacimiento;
    private Integer fechaFallecimiento;


    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LibroClass> libros;

    public AutorClass(){}


    public AutorClass(DatosAutor datosAutor){
        this.nombreAutor = datosAutor.nombreAutor();
        if (datosAutor.fechaFallecimiento()==null){
            this.fechaFallecimiento = 1980;

        }else{
            this.fechaFallecimiento = datosAutor.fechaFallecimiento();
        }
        if (datosAutor.fechaNacimiento()==null){
            this.fechaNacimiento = 3022;
        }else {
            this.fechaNacimiento = datosAutor.fechaNacimiento();
        }
    }

    @Override
    public String toString() {
        return
                "nombreAutor='" + nombreAutor + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaFallecimiento=" + fechaFallecimiento +
                ", libros=" + libros ;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public List<LibroClass> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroClass> libros) {
        libros.forEach(e->e.setAutor(this));
        this.libros = libros;
    }
}
