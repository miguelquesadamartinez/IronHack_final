package lab.miguel.code.controllers.interfaces;

import lab.miguel.code.controllers.DTOs.BalanceDTO;
import lab.miguel.code.entity.Account;

public interface AccountControllerInterface {

    BalanceDTO getBalance(Long id);
}
