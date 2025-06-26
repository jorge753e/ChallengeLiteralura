package com.alura.literaluraBA.principal;

import com.alura.literaluraBA.model.*;
import com.alura.literaluraBA.repository.AutorRepository;
import com.alura.literaluraBA.repository.LibroRepository;
import com.alura.literaluraBA.service.ConsumoAPI;
import com.alura.literaluraBA.service.ConvierteDatos;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private AutorRepository autorRepository;
    private LibroRepository libroRepository;
    private Scanner teclado = new Scanner(System.in);
    private ConvierteDatos conversorDatos = new ConvierteDatos();
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private Optional<LibroClass> libroBuscado;

    private List<AutorClass> autores = new ArrayList<>();

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository){
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    public void muestraMenu() {
        var opcion = -1;
        while(opcion != 0){
            var menu = """
                        *********** MENU ***************
                        1- Buscar Libros web
                        2- Lista de libros registrados
                        3- Buscar libro por titulo
                        4- Listar autores registrado
                        5- Listar autores vivos desde el año
                        6- Listar Libros por idioma
                        0- Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    buscarLibroWeb();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    buscarLibroPorTitulo();
                    break;
                case 4:
                    autoresRegistrados();
                    break;
                case 5:
                    autoresVivos();
                    break;
                case 6:
                    listaPorIdioma();
                    break;

                case 0:
                    System.out.println("Cerrando aplicación");
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        }
            }

    private void listaPorIdioma() {
        System.out.println("Elegir el idioma de libros: " + "\n es - español \n en - english");
        var enviarIdioma = teclado.nextLine();
        List<LibroClass> librosEncontrados = libroRepository.findByIdioma(enviarIdioma);
        if (!librosEncontrados.isEmpty()){
            System.out.println(" *********** LIBROS EN " + enviarIdioma.replace("es", "ESPAÑOL").replace("en", "INGLES") + " +++++++++++++++++");
            librosEncontrados.forEach(l-> System.out.println("Nombre del libro: " + l.getTitulo() +
                    "\n Idioma: " + l.getIdioma() + "\n Autor: " + l.getAutor().getNombreAutor()));
            System.out.println("**********************************\n ");
        }else {
            System.out.println("NO HAY LIBROS EN ESE IDIOMA");
        }



    }

    private void autoresVivos() {
//        System.out.println("Escribe el año que desea buscar:  ");
        int anio;
//        var anio = teclado.nextInt();
        while(true){
            System.out.println("Ingresa el año: ");
            if (teclado.hasNextInt()){
                anio = teclado.nextInt();
                break; // sale del bucle si la entrada es valida
            }else{
                System.out.println("Error al ingresar el formato del numero debe ser en números");
                teclado.next(); // limpia el valor
            }
        }
//        System.out.println("El año ingreso es : " + anio);
        autores = autorRepository.findByYear(anio);
        if (!autores.isEmpty()) { // SI AUTORES NO ESTA VACIO
            System.out.println("*********** AUTORES ****************");
            autores.forEach(a -> System.out.println("Nombre: " + a.getNombreAutor()
                    + "\n Fecha Nacimiento: " + a.getFechaNacimiento()
                    + "\n Fecha Fallecimineto: " + a.getFechaFallecimiento() + "\n "));
        } else {
            System.out.println("No hay autores vivos en ese año");
        }

    }

    private void autoresRegistrados() {

        autores = autorRepository.findAll();
        autores.stream()
                .collect(Collectors.toMap(a->a.getNombreAutor() + a.getFechaFallecimiento() + a.getFechaNacimiento(),
                        a->a,
                        (existing, replacement) -> existing))
                .values().stream()
                .toList();
        System.out.println("--------------LISTA DE AUTORES REGISTRADO ----------------");
//        autores.forEach(a-> System.out.println("Autor: " + a.getNombreAutor() +
//                "\n Fecha Nacimiento: " + a.getFechaNacimiento() + "\n Fecha de Fallecimiento: " + a.getFechaFallecimiento()
//        +   "Libros: " ) );


        autores.forEach(a -> {
            System.out.println("Autor: " + a.getNombreAutor() +
                    "\n Fecha Nacimiento: " + a.getFechaNacimiento() + "\n Fecha de Fallecimiento: " + a.getFechaFallecimiento()
                    + "\nLibros:");
            a.getLibros().forEach(libro -> System.out.println("- " + libro.getTitulo() + "\n "));
        });
        System.out.println(" ------------------------- \n");

    }

    private void buscarLibroPorTitulo() {
        System.out.println("Escribre el nombre del libro que desea buscar: ");
        var nombreLibroBuscado = teclado.nextLine();
        libroBuscado = libroRepository.findByTituloContainsIgnoreCase(nombreLibroBuscado);
        if (libroBuscado.isPresent()){
            System.out.println("---------- LIBRO --------------");
            System.out.println("Titulo: " + libroBuscado.get().getTitulo() + "\n Autor: " + libroBuscado.get().getAutor().getNombreAutor()
            + "\n Idioma: " + libroBuscado.get().getIdioma() + "\n N° de descargas: "+ libroBuscado.get().getTotalDescargas());
            System.out.println("\n ------------------------------- \n ");
        }else{
            System.out.println("Libro no encontrado");
        }


    }

    private void listarLibros() {
        List<LibroClass> libros = libroRepository.findAll();
        if (!libros.isEmpty()){
            System.out.println("*** LISTA DE LIBROS REGISTRADOS *** \n");
            libros.forEach(l-> System.out.println("Titulo libro: " + l.getTitulo()
            + "\nIdioma: " + l.getIdioma() +
                    "\nAutor: " + l.getAutor().getNombreAutor()
            + "\nN° Descargas: "+ l.getTotalDescargas() + "\n"));
            System.out.println("*********************************\n");

        }else {
            System.out.println("\n NO HAY LIBROS EN LA BASE DE DATOS\n");
        }

    }

    private void buscarLibroWeb() {
        DatosLibro datosLibro = getDatosLibro();
        if (datosLibro != null)
        {
            LibroClass libro;
            DatosAutor datosAutor = datosLibro.autor().get(0);
            AutorClass autorExistente = autorRepository.findByNombre(datosAutor.nombreAutor());
            if (autorExistente!= null){
                libro = new LibroClass(datosLibro, autorExistente);
            }else {
                AutorClass nuevoAutor = new AutorClass(datosAutor);
                libro = new LibroClass(datosLibro, nuevoAutor);
                autorRepository.save(nuevoAutor);
            }
            try {
                libroRepository.save(libro);
                System.out.println(libro);
                System.out.println("Libro registrado correctamente =) ");
            }catch (Exception e){
                System.out.println("No puedes registrar el mismo libro mas de una vez");
            }
        }else {
            System.out.println("No hemos encontrado el libro en la API");
        }
//       if (!resultadosApi.resultado().isEmpty()){
//           //aqui de la lista de libros retornados de resultado especifica el primer libro con el get 0
//           LibroClass libro = new LibroClass(resultadosApi.resultado().get(0));
//
//           libroRepository.save(libro);
//       }
//
//        System.out.println("Datos: ");
//        System.out.println(resultadosApi);


    }

    private DatosLibro getDatosLibro() {
        System.out.println("Ingrese el titulo del libro");
        var nombreLibro = teclado.nextLine();
        nombreLibro = nombreLibro.replace(" ", "%20");
        var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro);

        ResultadosApi datosBusqueda = conversorDatos.obtenerDatos(json, ResultadosApi.class);
        String finalNombreLibro = nombreLibro;
        Optional<DatosLibro> libroBuscado = datosBusqueda.resultado().stream()
                .filter(libro->libro.titulo().toLowerCase().contains(finalNombreLibro.toLowerCase()))
                .findFirst();
        return libroBuscado.orElse(null);

//        System.out.println(json);
//        ResultadosApi resultadosApi = conversorDatos.obtenerDatos(json, ResultadosApi.class);
//        return  resultadosApi;
    }
}
