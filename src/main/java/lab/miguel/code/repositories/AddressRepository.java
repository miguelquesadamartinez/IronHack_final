package lab.miguel.code.repositories;

import lab.miguel.code.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
