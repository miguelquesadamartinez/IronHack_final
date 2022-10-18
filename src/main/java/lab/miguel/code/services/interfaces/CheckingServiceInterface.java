package lab.miguel.code.services.interfaces;

import lab.miguel.code.controllers.DTOs.CreateCheckingDTO;
import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Checking;

import java.util.Optional;

public interface CheckingServiceInterface {

    public Checking createChecking(CreateCheckingDTO checkingDTO);

}
