package lab.miguel.code.repositories;

import lab.miguel.code.entity.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Long> {

    ThirdParty findByHashedKey (String hashedKey);

}
