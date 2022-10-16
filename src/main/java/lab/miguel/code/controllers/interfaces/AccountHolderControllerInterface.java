package lab.miguel.code.controllers.interfaces;

import lab.miguel.code.entity.AccountHolders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AccountHolderControllerInterface {

    public AccountHolders createAccountHolder(@RequestBody AccountHolders accountHolders);
    public List<AccountHolders> findAll();
    public AccountHolders findById(@PathVariable Long id);

}
