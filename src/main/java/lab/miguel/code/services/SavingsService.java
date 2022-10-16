package lab.miguel.code.services;

import lab.miguel.code.entity.Savings;
import lab.miguel.code.repositories.SavingsRepository;
import lab.miguel.code.services.interfaces.SavingsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsService implements SavingsServiceInterface {

    @Autowired
    SavingsRepository savingsRepository;

    @Override
    public Savings createSavings(Savings savings) {
        return savingsRepository.save(savings);
    }
}
