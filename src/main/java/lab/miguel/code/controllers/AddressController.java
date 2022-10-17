package lab.miguel.code.controllers;

import lab.miguel.code.controllers.interfaces.AddressControllerInterface;
import lab.miguel.code.entity.Address;
import lab.miguel.code.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController implements AddressControllerInterface {
    @Autowired
    AddressService addressService;

    @PostMapping("/create-address")
    @ResponseStatus(HttpStatus.OK)
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @GetMapping("/get-addresses")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/get-address/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address findById(@PathVariable Long id){
        return addressService.findById(id);
    }
}
