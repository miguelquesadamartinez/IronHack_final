package lab.miguel.code.controllers.interfaces;

import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Address;
import lab.miguel.code.services.interfaces.AddressServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AddressControllerInterface {

    public Address createAddress(@RequestBody Address accountHolders);
    public List<Address> findAll();
    public Address findById(@PathVariable Long id);

}
