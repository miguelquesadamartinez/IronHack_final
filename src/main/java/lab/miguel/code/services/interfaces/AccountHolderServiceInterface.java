package lab.miguel.code.services.interfaces;

import lab.miguel.code.entity.AccountHolders;

import java.util.List;

public interface AccountHolderServiceInterface {

    AccountHolders createAccountHolder(AccountHolders accountHolders);
    public AccountHolders findById(Long id);
    public List<AccountHolders> findAll();

}
