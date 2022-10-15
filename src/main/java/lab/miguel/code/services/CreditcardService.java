package lab.miguel.code.services;

import lab.miguel.code.repositories.CreditcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditcardService {

    @Autowired(required = false)
    CreditcardRepository creditcardRepository;

}
