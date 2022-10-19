package lab.miguel.code;

import lab.miguel.code.controllers.DTOs.*;
import lab.miguel.code.entity.*;
import lab.miguel.code.enums.Status;
import lab.miguel.code.repositories.CheckingRepository;
import lab.miguel.code.repositories.RoleRepository;
import lab.miguel.code.repositories.UserRepository;
import lab.miguel.code.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MiguelApplication implements CommandLineRunner {
	@Autowired
	AddressService addressService;
	@Autowired
	AccountHolderService accountHolderService;
	@Autowired
	SavingsService savingsService;
	@Autowired
	CheckingService checkingService;
	@Autowired
	CreditcardService creditcardService;
	@Autowired
	StudentService studentService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;


	// TODO: Las tablas ... me ha creado pocas, no ?

	public static void main(String[] args) {

		SpringApplication.run(MiguelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Address addr1 = addressService.createAddress(new Address("Velia, 81"));
		Address addr2 = addressService.createAddress(new Address("Papiol, 81"));
		Address addr3 = addressService.createAddress(new Address("Cuenca, 81"));
		Address addr4 = addressService.createAddress(new Address("Velia, 69"));

		AccountHolders accHold1 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Miguel", "18/04/1975", 1l, 1l));
		AccountHolders accHold2 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Pepe", "18/04/1975", 1l, 1l));
		AccountHolders accHold3 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Miguel", "18/04/1975", 1l, 1l));
		AccountHolders accHold4 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Pepe", "18/04/1975", 1l, 1l));
		AccountHolders accHold5 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Miguel", "18/04/1975", 1l, 1l));
		AccountHolders accHold6 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Pepe", "18/04/1975", 1l, 1l));
		AccountHolders accHold7 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Miguel", "18/04/1975", 1l, 1l));
		AccountHolders accHold8 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Pepe", "18/04/1975", 1l, 1l));

		Checking checking1 = checkingService.createChecking(new CreateCheckingDTO(500, 5l, 6l, LocalDate.now(), Status.ACTIVE, "12345", LocalDate.now(), 10, 100));
		Creditcard credit1 = creditcardService.createCreditcard(new CreateCreditCardDTO(500, 7l, 8l, LocalDate.now(), Status.ACTIVE, "12345", LocalDate.now(), 1000, 0.2));
		Savings savings1 = savingsService.createSavings(new CreateSavingsDTO(500, 9l, 10l, LocalDate.now(), Status.ACTIVE, "12345", LocalDate.now(), 0.0025, 500));
		StudentChecking student1 = studentService.createStudent(new CreateStudentDTO(500, 11l, 12l, LocalDate.now(), Status.ACTIVE, "12345", LocalDate.now()));


		User usuario1 = userRepository.save(new User("miguel", "1804"));

		Role rol1 = roleRepository.save(new Role("ADMIN", usuario1));
	}
}
