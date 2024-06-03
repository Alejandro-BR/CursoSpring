package com.alejandro.curso.springboot.jpa.springboot_jpa_relationship;

// import java.util.ArrayList;
// import java.util.Arrays;
import java.util.HashSet;
// import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.entities.Address;
import com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.entities.Client;
import com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.entities.Invoice;
import com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.repositories.ClientRepository;
import com.alejandro.curso.springboot.jpa.springboot_jpa_relationship.repositories.InvoiceRepository;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// manyToOne();
		// manyToOneFindByIdClient();
		// OneToMany();
		// OneToManyFinById();
		// removeAddress();
		// removeAddressFindById();
		// OneToManyInvoiceBidireccional();
		// OneToManyInvoiceBidireccionalFindById();
		removerInvoiceBidireccionalFindById();
	}

	@Transactional
	public void removerInvoiceBidireccionalFindById() {

		Optional<Client> optionalClient = clientRepository.findOne(1L);

		optionalClient.ifPresent(client -> {

			Invoice invoice1 = new Invoice("Compras de la casa", 5000L);
			Invoice invoice2 = new Invoice("Compras de oficina", 8000L);

			Set<Invoice> invoices = new HashSet<>();
			invoices.add(invoice2);
			invoices.add(invoice1);
			client.setInvoices(invoices);

			invoice1.setClient(client);
			invoice2.setClient(client);
	
			clientRepository.save(client);
	
			System.out.println("\033[0;94m" + client + "\033[0;0m");
		});

		Optional<Client> optionalClientDB = clientRepository.findOne(1L);

		optionalClientDB.ifPresent(client -> {
			Optional<Invoice> optionalInvoice = invoiceRepository.findById(2L);
			optionalInvoice.ifPresent(invoice -> {
				
				client.getInvoices().remove(invoice);
				invoice.setClient(null);

				clientRepository.save(client);

				System.out.println("\033[0;94m" + client + "\033[0;0m");
			});
		});
	}

	@Transactional
	public void OneToManyInvoiceBidireccionalFindById() {

		Optional<Client> optionalClient = clientRepository.findOneWirhInvoices(1L);

		optionalClient.ifPresent(client -> {

			Invoice invoice1 = new Invoice("Compras de la casa", 5000L);
			Invoice invoice2 = new Invoice("Compras de oficina", 8000L);

			Set<Invoice> invoices = new HashSet<>();
			// List<Invoice> invoices = new ArrayList<>();
			invoices.add(invoice2);
			invoices.add(invoice1);
			client.setInvoices(invoices);

			invoice1.setClient(client);
			invoice2.setClient(client);
	
			clientRepository.save(client);
	
			System.out.println("\033[0;94m" + client + "\033[0;0m");
		});
	}

	@Transactional
	public void OneToManyInvoiceBidireccional() {

		Client client = new Client("Fran", "Moras");

		Invoice invoice1 = new Invoice("Compras de la casa", 5000L);
		Invoice invoice2 = new Invoice("Compras de oficina", 8000L);

		Set<Invoice> invoices = new HashSet<>();
		// List<Invoice> invoices = new ArrayList<>();
		invoices.add(invoice2);
		invoices.add(invoice1);
		client.setInvoices(invoices);

		invoice1.setClient(client);
		invoice2.setClient(client);

		clientRepository.save(client);

		System.out.println("\033[0;94m" + client + "\033[0;0m");

	}

	// @Transactional
	// public void removeAddressFindById() {
	// 	Optional<Client> optionalClient = clientRepository.findOne(1L);
	// 	// Optional<Client> optionalClient = clientRepository.findOneAddresesses(1L);

	// 	if (!optionalClient.isPresent()) {
	// 		System.out.println("No se encontró el cliente con ID 1");
	// 		return;
	// 	}

	// 	optionalClient.ifPresent(client -> {
	// 		Address address1 = new Address("Malaga", 1234);
	// 		Address address2 = new Address("Madrid", 4321);

	// 		client.setAddresses(Arrays.asList(address1, address2));

	// 		clientRepository.save(client);

	// 		System.out.println("\033[0;94m" + client + "\033[0;0m");

	// 		optionalClient.ifPresent(c -> {
	// 			List<Address> currentAddresses = new ArrayList<>(c.getAddresses());
	// 			currentAddresses.remove(address1);
	// 			c.setAddresses(currentAddresses);
	// 			clientRepository.save(c);

	// 			System.out.println("\033[0;94m" + c + "\033[0;0m");
	// 		});
	// 	});

	// }

	@Transactional
	public void removeAddress() {
		Client client = new Client("Fran", "Moras");

		Address address1 = new Address("El verjel", 1234);
		Address address2 = new Address("Vasco de Gama", 9875);

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);

		System.out.println("\033[0;94m" + client + "\033[0;0m");

		Optional<Client> optionalClient = clientRepository.findById(3L);
		optionalClient.ifPresent(c -> {
			c.getAddresses().remove(address1);
			clientRepository.save(c);

			System.out.println("\033[0;94m" + c + "\033[0;0m");
		});
	}

	// @Transactional
	// public void OneToManyFinById() {
	// 	Optional<Client> optionalClient = clientRepository.findById(1L);

	// 	optionalClient.ifPresent(client -> {
	// 		Address address1 = new Address("Malaga", 1234);
	// 		Address address2 = new Address("Madrid", 4321);

	// 		client.setAddresses(Arrays.asList(address1, address2));

	// 		clientRepository.save(client);

	// 		System.out.println("\033[0;94m" + client + "\033[0;0m");
	// 	});
	// }

	@Transactional
	public void OneToMany() {
		Client client = new Client("Fran", "Moras");

		Address address1 = new Address("El verjel", 1234);
		Address address2 = new Address("Vasco de Gama", 9875);

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);

		System.out.println("\033[0;94m" + client + "\033[0;0m");
	}

	@Transactional
	public void manyToOne() {

		Client client = new Client("John", "Doe");
		clientRepository.save(client);

		Invoice invoice = new Invoice("compras de oficina", 2000L);
		invoice.setClient(client);
		invoiceRepository.save(invoice);

		System.out.println(invoice);
	}

	@Transactional
	public void manyToOneFindByIdClient() {

		Optional<Client> optionalClient = clientRepository.findById(1L);
		if (optionalClient.isPresent()) {
			Client client = optionalClient.orElseThrow();
			clientRepository.save(client);

			Invoice invoice = new Invoice("compras de oficina", 2000L);
			invoice.setClient(client);
			invoiceRepository.save(invoice);

			System.out.println("\033[0;94m" + invoice + "\033[0;0m");
		}
	}

}
