package lab.miguel.code.services.interfaces;

import lab.miguel.code.entity.Address;

import java.util.List;

public interface AddressServiceInterface {

    Address createAddress(Address address);
    public List<Address> findAll();
    public Address findById(Long id);
}
