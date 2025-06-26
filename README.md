# ChallengeLiteralura
Descripción: Esta es una aplicación de consola desarrollada en Java con Spring Framework, ejecutada desde IntelliJ IDEA, que permite interactuar con una base de datos de libros y autores utilizando datos obtenidos desde la API pública de Gutendex.

💡 El sistema está diseñado para cumplir siete funcionalidades principales, enfocadas en la gestión y consulta de libros y autores sin necesidad de una interfaz gráfica (frontend):

1. Buscar libros por titulo en la web
El usuario puede ingresar un título de libro, que será buscado en la API externa. Si se encuentra, su información será almacenada automáticamente en la base de datos.

2. Listar libros registrados
Se muestra un listado completo de todos los libros almacenados en la base de datos, incluyendo títulos como Don Quijote o Pride and Prejudice.

3. Buscar Libro por titulo
El usuario ingresa el nombre de algun libro para buscarlo en la lista de libros registrados en la base de datos.

4. Listar autores registrados
Se presenta la lista de todos los autores almacenados, formateando sus nombres como: Apellido, Nombre , Fecha de nacimiento, fecha de fallecimiento y los libros escritos por el autor.

5. Listar autores vivos en un año específico
El usuario ingresa un año (por ejemplo, 1600) y se muestran los autores que estaban vivos durante ese año, como Miguel de Cervantes o William Shakespeare.

6. Filtrar libros por idioma
Permite mostrar libros almacenados según el idioma seleccionado (por ejemplo, ES para español, EN para inglés).

7. Salir del programa

🚀Ejemplos de uso:
- Al ejecutar el programa mostrará el siguiente menu:
![image](https://github.com/user-attachments/assets/54737ae6-c631-4e3d-8eb8-54c4c1db2620)
- Se escribe el número de la opción que desea ingresar y se da enter.
📓 - Opción 1: Se escribe el titulo del libro "trafalgar" , luego enter
![image](https://github.com/user-attachments/assets/d2f3f170-5fec-4fa7-99de-84295956a206)
📓 Opción 2: Listar libros registrados, escribir el número 2, dar enter y se mostrarán los libros registrados
![image](https://github.com/user-attachments/assets/9b15bcdb-898d-4e44-8e1b-e08b32e06659)
📓Opción 3: Buscar libro por titulo: Escribir 3, luego escribir el titulo del libro "quijote" por ejemplo y se msotrará:
![image](https://github.com/user-attachments/assets/102b7d38-2c2f-4373-89b5-35f8d370c26f)
📓 Opción 4: Listar autores registrados, escribir el número 4 y luego el programa mostrará los autores registrados
![image](https://github.com/user-attachments/assets/9312c148-2be3-4a48-a2b8-fdaff30fb8a1)

📓 Opción 5: Listar autores vivos en un determinado año: escribir la opción 5, luego digitar el año en números y el programa mostrará los autores vivos en ese año
![image](https://github.com/user-attachments/assets/4d5fc2cc-f86b-45f2-a4c2-12cc5cac04bb)

📓 Opción 6: Listar libros por idioma, escribir la opción 6, luego escribir el idioma "en" o "es" y dar un enter
![image](https://github.com/user-attachments/assets/fba5d8b7-0e97-4576-8a56-dfb92f0a34a9)

📓Opción 0: Salir del programá 
Escribir 0 el programa habra dado por terminado su ejecución 

💡 Esta aplicación está orientada a la lógica de backend y persistencia de datos, sin requerir interfaz gráfica. Toda la interacción se realiza a través de la consola.
- El programá no permite ingresar libros duplicados
- Resguarda le formato de números para el ingreso de año en la opción 5
- 
Posibles mejoras:
- Añadir estadisticas
- Añadir top de libros por descargas

Tecnologias usadas:
- 🌟 Consumo api GUTENDEX
- 🌟 CRUD LIBROS
- 🌟 MANEJO DATOS DTOS
- 🌟 JPA
- 🌟 MYSQL

 Redes sociales 🤝

-  GitHub: https://github.com/jorge753e
-  Linkedin https://www.linkedin.com/in/jorge-maquera-rp/
