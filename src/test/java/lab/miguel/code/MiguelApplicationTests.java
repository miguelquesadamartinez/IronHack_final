package lab.miguel.code;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab.miguel.code.controllers.DTOs.*;
import lab.miguel.code.entity.*;
import lab.miguel.code.enums.Status;
import lab.miguel.code.repositories.*;
import lab.miguel.code.services.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.swing.text.html.Option;
import java.awt.dnd.DragSourceMotionListener;
import java.time.LocalDate;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MiguelApplicationTests {
	@Autowired
	AddressService addressService;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	AccountHolderService accountHolderService;
	@Autowired
	AccountHolderRepository accountHolderRepository;

	@Autowired
	AccountService accountService;
	@Autowired
	SavingsService savingsService;
	@Autowired
	SavingsRepository savingsRepository;
	@Autowired
	CheckingService checkingService;
	@Autowired
	CheckingRepository checkingRepository;
	@Autowired
	CreditcardService creditcardService;
	@Autowired
	CreditcardRepository creditcardRepository;
	@Autowired
	StudentService studentService;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	ThirdPartyService thirdPartyService;
	@Autowired
	ThirdPartyRepository thirdPartyRepository;
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	private final ObjectMapper objectMapper = new ObjectMapper();


	@BeforeEach
	void set_up(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

		addressRepository.save(new Address("Velia, 81"));
		addressRepository.save(new Address("Velia, 69"));

		accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Miguel", "1975-04-18", 1l, 1l));
		accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Pepe", "2000-02-01", 1l, 1l));

	}

	@Test
	void mock_create_address() throws Exception{
		Address addr1 = new Address("Velia, 81");

		String body = objectMapper.writeValueAsString(addr1);

		MvcResult mvcResult = mockMvc.perform(post("/create-address").content(body).
				contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();

		ObjectMapper mapper = new ObjectMapper();
		JsonNode tree = mapper.readTree(mvcResult.getResponse().getContentAsString());
		JsonNode node = tree.get("id");
		Long id = node.asLong();

		Assertions.assertTrue(addressRepository.findById(id).isPresent());
	}


	@Test
	void create_address() {
		Address address = addressRepository.save(new Address("Velia, 81"));
		Optional<Address> addrOpt = addressRepository.findById(address.getId());
		Assertions.assertTrue(addrOpt.isPresent());
	}

	@Test
	void create_account_holder() {
		Address addr1 = addressRepository.save(new Address("Velia, 81"));
		Address addr2 = addressRepository.save(new Address("Velia, 69"));
		AccountHolders acc1 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Miguel", "1975-04-18", addr1.getId(), addr2.getId()));

		Optional<AccountHolders> accOpt = accountHolderRepository.findById(acc1.getId());
		Assertions.assertTrue(accOpt.isPresent());
	}

	@Test
	void create_checking() {
		Address addr1 = addressRepository.save(new Address("Velia, 81"));
		Address addr2 = addressRepository.save(new Address("Velia, 69"));
		AccountHolders acc1 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Miguel", "1975-04-18", addr1.getId(), addr2.getId()));
		AccountHolders acc2 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Pepe", "2000-02-01", addr1.getId(), addr2.getId()));

		Checking checking = checkingService.createChecking(new CreateCheckingDTO(500, acc1.getId(), acc2.getId(), LocalDate.now(), Status.ACTIVE, "12345", LocalDate.now(), 10, 100));
		Optional<Checking> chkOpt = checkingRepository.findById(checking.getId());
		Assertions.assertTrue(chkOpt.isPresent());
	}

	@Test
	void create_credit_card(){
		Address addr1 = addressRepository.save(new Address("Velia, 81"));
		Address addr2 = addressRepository.save(new Address("Velia, 69"));
		AccountHolders acc1 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Miguel", "1975-04-18", addr1.getId(), addr2.getId()));
		AccountHolders acc2 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Pepe", "2000-02-01", addr1.getId(), addr2.getId()));

		Creditcard creditcard  = creditcardService.createCreditcard(new CreateCreditCardDTO(1500, 7l, 8l, LocalDate.now(), Status.ACTIVE, "12345", LocalDate.now(), 1000, 0.2));
		Optional<Creditcard> credOpt = creditcardRepository.findById(creditcard.getId());
		Assertions.assertTrue(credOpt.isPresent());
	}

	@Test
	void create_savings(){
		Address addr1 = addressRepository.save(new Address("Velia, 81"));
		Address addr2 = addressRepository.save(new Address("Velia, 69"));
		AccountHolders acc1 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Miguel", "1975-04-18", addr1.getId(), addr2.getId()));
		AccountHolders acc2 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Pepe", "2000-02-01", addr1.getId(), addr2.getId()));

		Savings savings = savingsService.createSavings(new CreateSavingsDTO(2500, 9l, 10l, LocalDate.now(), Status.ACTIVE, "12345", LocalDate.now(), 0.0025, 500));
		Optional<Savings> savOpt = savingsRepository.findById(savings.getId());
		Assertions.assertTrue(savOpt.isPresent());


	}
	@Test
	void create_student (){
		Address addr1 = addressRepository.save(new Address("Velia, 81"));
		Address addr2 = addressRepository.save(new Address("Velia, 69"));
		AccountHolders acc1 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Miguel", "1975-04-18", addr1.getId(), addr2.getId()));
		AccountHolders acc2 = accountHolderService.createAccountHolder(new CreateAccountHolderDTO("Pepe", "2000-02-01", addr1.getId(), addr2.getId()));

		StudentChecking studentChecking = studentService.createStudent(new CreateStudentDTO(3500, acc1.getId(), acc2.getId(), LocalDate.now(), Status.ACTIVE, "12345", LocalDate.now()));
		Optional<StudentChecking> stdOpt = studentRepository.findById(studentChecking.getId());
		Assertions.assertTrue(stdOpt.isPresent());
	}



	@Test
	void create_third_party(){
		ThirdParty thirdParty1 = thirdPartyService.createThirdParty(new ThirdPartyDTO( "aaaaaaa", "Miguel", 100l));
		Optional<ThirdParty> thrOpt = thirdPartyRepository.findById(thirdParty1.getId());
		Assertions.assertTrue(thrOpt.isPresent());
	}

	@Test
	void transfer_account(){
		Assertions.assertEquals( 500, accountService.getBalance(13l).getBalance());
		Assertions.assertEquals(1500, accountService.getBalance(14l).getBalance());
		accountService.transferToAccount(new TransferDTO(13, 100, 7, 8));
		Assertions.assertEquals( 400, accountService.getBalance(13l).getBalance());
		Assertions.assertEquals(1600, accountService.getBalance(14l).getBalance());
	}



}
