/**
 * Clase principal de Spring:
 * 
 *  @author Alejandro Barrionuevo Rosado
 */

package com.alejandro.curso.srpingboot.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.alejandro.curso.srpingboot.jpa.springboot_jpa.entities.Person;
import com.alejandro.curso.srpingboot.jpa.springboot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		findOne();
		list();
		// create();
		// update();
		// delete();
		// delete2();
	}

	/**
	 * Crear una nueva persona para la base de datos
	 */
	@Transactional
	public void create() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("\n\033[0;95m" + "Introduce el nombre: " + "\033[0;0m");
		String name = scanner.next();
		System.out.print("\033[0;95m" + "Introduce el apellido: " + "\033[0;0m");
		String lastname = scanner.next();
		System.out.print("\033[0;95m" + "Introduce el lenguaje de programacion: " + "\033[0;0m");
		String programingLanguage = scanner.next();
		System.out.println("\033[0;95m" + "El id se generara automaticamente. " + "\033[0;0m");
		scanner.close();

		Person person = new Person(null, name, lastname, programingLanguage);

		Person personNew = repository.save(person);

		repository.findById(personNew.getId())
				.ifPresent(p -> System.out.println("\033[0;95m" + personNew + "\033[0;0m"));
	}

	/**
	 * Actualizar el lenguaje de programacion de una persona:
	 */
	@Transactional
	public void update() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\n\033[0;96m" + "Ingrese el id de la persona: " + "\033[0;0m");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);

		// optionalPerson.ifPresent(person -> {
		if (optionalPerson.isPresent()) {

			Person person = optionalPerson.orElseThrow();

			System.out.println("\033[0;96m" + person + "\033[0;0m");
			System.out.print("\n\033[0;96m" + "Ingrese el lenguaje de programacion: " + "\033[0;0m");
			String programmingLanguage = scanner.next();
			person.setProgramingLanguage(programmingLanguage);
			Person personDB = repository.save(person);
			System.out.println("\033[0;96m" + personDB + "\033[0;0m");
		} else {
			System.out.println("\n\033[0;96m" + "EL usuario no existe! " + "\033[0;0m");
		}
		// });

		scanner.close();
	}

	/**
	 * Eliminar un usuario
	 */
	@Transactional
	public void delete() {

		System.out.print("\033[0;92m");
		repository.findAll().forEach(System.out::println);
		System.out.print("\033[0;0m");

		Scanner scanner = new Scanner(System.in);
		System.out.print("\n\033[0;92m" + "Ingrese el id de la persona: " + "\033[0;0m");
		Long id = scanner.nextLong();

		repository.deleteById(id);

		System.out.print("\033[0;92m");
		repository.findAll().forEach(System.out::println);
		System.out.print("\033[0;0m");

		scanner.close();
	}

	/**
	 * Eliminar un usuario segunda version
	 */
	@Transactional
	public void delete2() {

		System.out.print("\033[0;92m");
		repository.findAll().forEach(System.out::println);
		System.out.print("\033[0;0m");

		Scanner scanner = new Scanner(System.in);
		System.out.print("\n\033[0;92m" + "Ingrese el id de la persona: " + "\033[0;0m");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);

		optionalPerson.ifPresentOrElse(
				person -> repository.delete(person),
				() -> System.out.println("\033[0;92m" + "No existe una persona con ese id." + "\033[0;0m"));

		System.out.print("\033[0;92m");
		repository.findAll().forEach(System.out::println);
		System.out.print("\033[0;0m");

		scanner.close();
	}

	/**
	 * Consulta de una sola persona
	 */
	@Transactional(readOnly = true)
	public void findOne() {

		// Person person = null;
		// Optional<Person> optionalPeson = repository.findById(2L);
		// if (optionalPeson.isPresent()) {
		// person = optionalPeson.get();
		// System.out.println("\033[0;93m" + person + "\033[0;0m");
		// } else {
		// System.out.println("\033[0;93m" + "No existe ninguna persona con ese ID." +
		// "\033[0;0m");
		// }

		// Todo en una linea pero sin ese mensaje de no encontrarlo:
		// repository.findById(1L).ifPresent(person -> System.out.println(person));

		repository.findOne(1L).ifPresent(person -> System.out.println("\033[0;93m" + person + "\033[0;0m"));
		repository.findOneName("Alejandro")
				.ifPresent(person -> System.out.println("\033[0;93m" + person + "\033[0;0m"));
		repository.findOneLikeName("ri").ifPresent(person -> System.out.println("\033[0;93m" + person + "\033[0;0m"));
		repository.findByNameContaining("Al")
				.ifPresent(person -> System.out.println("\033[0;93m" + person + "\033[0;0m"));
	}

	/**
	 * Consultas de listas
	 * 
	 */
	@Transactional(readOnly = true)
	public void list() {

		// List<Person> persons = (List<Person>) repository.findAll();
		// List<Person> persons = (List<Person>)
		// repository.findByProgramingLanguageAndName("Java","Alejandro");
		List<Person> persons = (List<Person>) repository.findByProgramingLanguage("Java");

		persons.stream().forEach(person -> {
			System.out.println("\033[0;94m" + person + "\033[0;0m");
		});

		List<Object[]> personsValues = repository.obtenerPersonData();
		personsValues.stream().forEach(person -> {
			System.out.println("\033[0;94m" + person[0] + " es experto en " + person[1] + "\033[0;0m");
		});
	}

}
