package lab.miguel.code.services.interfaces;

import lab.miguel.code.controllers.DTOs.BalanceDTO;
import lab.miguel.code.entity.Account;

public interface AccountServiceInterface {

    BalanceDTO getBalance(Long id);
}
