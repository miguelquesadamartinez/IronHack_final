package lab.miguel.code.services;

import lab.miguel.code.repositories.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsService {

    @Autowired(required = false)
    SavingsRepository savingsRepository;


}
