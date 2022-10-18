package lab.miguel.code.controllers.interfaces;

import lab.miguel.code.controllers.DTOs.CreateCheckingDTO;
import lab.miguel.code.entity.Account;
import lab.miguel.code.entity.Checking;

public interface CheckingControllerInterfce {

    Checking createChecking(CreateCheckingDTO checking);

}
