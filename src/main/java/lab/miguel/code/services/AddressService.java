package lab.miguel.code.services;

import lab.miguel.code.entity.AccountHolders;
import lab.miguel.code.entity.Address;
import lab.miguel.code.repositories.AddressRepository;
import lab.miguel.code.services.interfaces.AddressServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class AddressService implements AddressServiceInterface {

    AddressRepository addressRepository;

    @Override
    public Address createAddress(Address address) {

        if (address.getAddress() == "")
            throw new RuntimeException("Direccion vacia");
        return addressRepository.save(address);
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }
    public Address findById(Long id){
        if(!addressRepository.findById(id).isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return addressRepository.findById(id).get();
    }
}
