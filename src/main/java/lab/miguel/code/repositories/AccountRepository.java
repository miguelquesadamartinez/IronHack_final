package lab.miguel.code.repositories;

import lab.miguel.code.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


    // TODO: Peta
    Account findByPrimaryOwnerId (Long id);
    //Account findBySecondaryOwnerId (Long id);
}
