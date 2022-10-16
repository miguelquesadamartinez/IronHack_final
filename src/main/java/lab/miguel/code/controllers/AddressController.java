package lab.miguel.code.controllers;

import lab.miguel.code.controllers.interfaces.AddressControllerInterface;
import lab.miguel.code.entity.Address;
import lab.miguel.code.services.interfaces.AddressServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController implements AddressControllerInterface {
    @Autowired(required = false)
    AddressServiceInterface addressServiceInterface;

    @PostMapping("/create-address")
    @ResponseStatus(HttpStatus.OK)
    public Address createAddress(@RequestBody Address address){
        return addressServiceInterface.createAddress(address);
    }

    @GetMapping("/get-addresses")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> findAll(){
        return addressServiceInterface.findAll();
    }

    @GetMapping("/get-address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address findById(@PathVariable Long id){
        return addressServiceInterface.findById(id);
    }
}
