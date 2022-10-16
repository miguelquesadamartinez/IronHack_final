package lab.miguel.code.services.interfaces;

import lab.miguel.code.controllers.DTOs.BalanceDTO;
import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Checking;

import java.util.Optional;

public interface AccountServiceInterface {

    BalanceDTO getBalance(Long id);

    public void transferToAccount(Account origin, double amount, Optional<Account> holder1, Optional<Account> holder2);
}
