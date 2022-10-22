package lab.miguel.code.repositories;

import lab.miguel.code.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    @Query(value = "Select * from transactions group by id_account, fecha having count(*) > 2", nativeQuery = true)
    List<Transactions> getFraudTransactions();

}
