package lab.miguel.code.repositories;

import lab.miguel.code.entity.AccountHolders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHolderRepository extends JpaRepository<AccountHolders, Long> {
}
