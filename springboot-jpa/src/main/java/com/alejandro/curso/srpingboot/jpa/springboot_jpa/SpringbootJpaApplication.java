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

import com.alejandro.curso.srpingboot.jpa.springboot_jpa.dto.PersonDto;
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

		// findOne();
		// list();
		// create();
		// update();
		// delete();
		// delete2();
		// personalizedQueries();
		// personalizedQueries2();
		// personalizendQueriesDistinct();
		// personalizendQueriesConcatUpperAndLowerCase();
		// personalizedQueriesBerween();
		// queriesFunctionAggregation();
		// subQueries();
		whereIn();
	}

	@Transactional(readOnly = true)
	public void whereIn() {
		List<Person> persons = repository.getPersonsByIds();
		System.out.println("\n\033[0;94mConsulta where in \033[0;0m");
		System.out.println("\033[0;94m");
		persons.forEach(System.out::println);
		System.out.println("\033[0;0m");
	}

	/**
	 * Subconsultas
	 */
	@Transactional(readOnly = true)
	public void subQueries() {

		List<Object[]> regs = repository.getShorterName();
		System.out.println("\n\033[0;94m" + "Nombre y su longitud del nombre con la longitud minima:" + "\033[0;0m");
		regs.forEach(reg -> {
			String name = (String) reg[0];
			Integer length = (Integer) reg[1];
			System.out.println("\033[0;94m" + name + " --> " + length + "\033[0;0m");
		});

		Optional<Person> optionalPerson = repository.getLastRegistration();
		System.out.println("\n\033[0;94m" + "Consulta para optener el ultimo registro" + "\033[0;0m");
		System.out.println("\n\033[0;94m");
		optionalPerson.ifPresent(System.out::println);
		System.out.println("\n\033[0;0m");
	}

	/**
	 * Consultas con mint max, etc
	 */
	@Transactional(readOnly = true)
	public void queriesFunctionAggregation() {

		Long count = repository.totalPerson();
		Long mint = repository.minId();
		Long max = repository.maxId();

		System.out.println("\n\033[0;94m" + "Total de registros: " + count + "\033[0;0m");
		System.out.println("\n\033[0;94m" + "Id minimo: " + mint + "\033[0;0m");
		System.out.println("\n\033[0;94m" + "Id maximo: " + max + "\033[0;0m\n");

		List<Object[]> regs = repository.getPersonNameLengch();

		System.out.println("\n\033[0;94m" + "Nombre y su longitud:" + "\033[0;0m");
		regs.forEach(reg -> {
			String name = (String) reg[0];
			Integer length = (Integer) reg[1];
			System.out.println("\033[0;94m" + name + " --> " + length + "\033[0;0m");
		});

		Integer mintLength = repository.getMinLengthName();
		Integer maxLength = repository.getMaxLengthName();

		System.out.println("\n\033[0;94m" + "Longitud del nombre mas corto: " + mintLength + "\033[0;0m");
		System.out.println("\n\033[0;94m" + "Longitud del nombre mas largo: " + maxLength + "\033[0;0m\n");
	}

	@Transactional(readOnly = true)
	public void personalizedQueriesBerween() {

		System.out.println("\n\033[0;94m" + "Consultas por rangos:" + "\033[0;0m");

		List<Person> persons = repository.findAllBetweenId(2, 5);
		System.out.println("\033[0;94m");
		persons.forEach(System.out::println);
		System.out.println("\033[0;0m");

		persons = repository.findAllBetweenName("J", "Q");
		System.out.println("\033[0;94m");
		persons.forEach(System.out::println);
		System.out.println("\033[0;0m");

		persons = repository.findByIdBetweenOrderByNameAsc(2L, 5L);
		System.out.println("\033[0;94m");
		persons.forEach(System.out::println);
		System.out.println("\033[0;0m");

		persons = repository.findByNameBetween("J", "Q");
		System.out.println("\033[0;94m");
		persons.forEach(System.out::println);
		System.out.println("\033[0;0m");

		persons = repository.getAll();
		System.out.println("\033[0;94m");
		persons.forEach(System.out::println);
		System.out.println("\033[0;0m");

	}

	/**
	 * Consultas cambiando el formato
	 */
	@Transactional(readOnly = true)
	public void personalizendQueriesConcatUpperAndLowerCase() {

		System.out.println("\n\033[0;93m" + "Consultas con nombres y apellidos:" + "\033[0;0m");

		List<String> names = repository.findAllFullNameConcat();
		System.out.println("\033[0;93m");
		names.forEach(System.out::println);
		System.out.println("\033[0;0m");

		List<String> namesUpper = repository.findAllFullNameConcatUpper();
		System.out.println("\033[0;93m");
		namesUpper.forEach(System.out::println);
		System.out.println("\033[0;0m");

		List<String> namesLowe = repository.findAllFullNameConcatLower();
		System.out.println("\033[0;93m");
		namesLowe.forEach(System.out::println);
		System.out.println("\033[0;0m");

		System.out.println("\n\033[0;93m" + "Consultas con nombres y apellidos mas el lenguage" + "\033[0;0m");

		List<String> namesAndLenguague = repository.findAllFullNameConcatAndProgramingLanguage();
		System.out.println("\033[0;93m");
		namesAndLenguague.forEach(System.out::println);
		System.out.println("\033[0;0m");
	}

	/**
	 * Consultas que uan del distinct
	 */
	@Transactional(readOnly = true)
	public void personalizendQueriesDistinct() {
		System.out.println("\n\033[0;93m" + "Consultas con nombres de persona:");
		List<String> names = repository.findAllNamesDistinct();
		names.forEach(System.out::println);
		System.out.println("\033[0;0m");

		System.out.println("\n\033[0;93m" + "Consultas con los lenguages de programacion:");
		List<String> programingLanguage = repository.findAllprogramingLanguageDistinct();
		programingLanguage.forEach(System.out::println);
		System.out.println("\033[0;0m");

		Long totalLenguage = repository.findAllprogramingLanguageDistinctCount();
		System.out.println("\033[0;93m" + "Total de lenguajes diferentes " + totalLenguage + "\033[0;0m");
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
	 * Consultas perzonalizadas
	 */
	@Transactional(readOnly = true)
	public void personalizedQueries2() {

		System.out.println(
				"\033[0;91m" + "====================== Consulta de nombre por id ======================" + "\033[0;0m");
		List<Object[]> personsRegs = repository.findAllMixPerson();

		personsRegs.forEach(
				reg -> {
					System.out.println("\033[0;91m" + reg[1] + " " + reg[0] + "\033[0;0m");
				});

		System.out.print("\033[0;91m");
		System.out.println("Consulta que pruebra y devuelve objeto entety de una instancia personalizada");
		System.out.print("\033[0;0m");
		List<Person> persons = repository.findAllObjectPersonPersonalized();
		persons.forEach(person -> System.out.println("\033[0;91m" + person + "\033[0;0m"));

		System.out.println("\033[0;91m");
		System.out.println("Consulta de PersonDto");
		System.out.print("\033[0;0m");
		List<PersonDto> personDtos = repository.findAllObjectPersonDto();
		personDtos.forEach(personDto -> System.out.println("\033[0;91m" + personDto + "\033[0;0m"));

	}

	/**
	 * Consultas personalizadas
	 */
	@Transactional(readOnly = true)
	public void personalizedQueries() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("\033[0;91m" + "====================== Consulta de nombre por id ======================");
		System.out.print("Introduce el id: " + "\033[0;0m");
		Long id = scanner.nextLong();

		// String name = repository.getNameById(id);
		// System.out.println("\033[0;91m" + name + "\033[0;0m");

		String name = repository.getFullNameById(id);
		System.out.println("\033[0;91m" + name + "\033[0;0m");

		Long idDb = repository.getIdById(id);
		System.out.println("\033[0;91m" + idDb + "\033[0;0m");

		System.out.println(
				"\033[0;91m" + "====================== Consulta por campos personalizado por id ======================"
						+ "\033[0;0m");

		Optional<Object[]> optionalpersorReg = Optional.ofNullable((Object[]) repository.obtenerPersonaById(id));
		if (optionalpersorReg.isPresent()) {
			Object[] persorReg = optionalpersorReg.get();
			System.out.println("\033[0;91m" + persorReg[0] + "\033[0;0m");
			System.out.println("\033[0;91m" + persorReg[1] + "\033[0;0m");
			System.out.println("\033[0;91m" + persorReg[2] + "\033[0;0m");
			System.out.println("\033[0;91m" + persorReg[3] + "\033[0;0m");
		}

		List<Object[]> regs = repository.obtenerPersonDataList();
		regs.forEach(reg -> System.out.println(reg[0] + " " + reg[1]));

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
