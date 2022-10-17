package lab.miguel.code;

import lab.miguel.code.controllers.DTOs.CreateAccountHolderDTO;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Address;
import lab.miguel.code.services.AccountHolderService;
import lab.miguel.code.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiguelApplication implements CommandLineRunner {
	@Autowired
	AddressService addressService;
	@Autowired
	AccountHolderService accountHolderService;

	// TODO: Las tablas ... me ha creado pocas, no ?

	public static void main(String[] args) {

		SpringApplication.run(MiguelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Address addr1 = addressService.createAddress(new Address("Velia, 81"));
		addressService.createAddress(new Address("Papiol, 81"));
		addressService.createAddress(new Address("Cuenca, 81"));
		addressService.createAddress(new Address("Velia, 69"));

		accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Miguel", "18/04/1975", 1l, 1l));

	}
}
