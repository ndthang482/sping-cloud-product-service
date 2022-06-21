package savvycom.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import savvycom.productservice.domain.entity.Address;
import savvycom.productservice.service.IAddressService;

import java.util.List;
@RestController
@RequestMapping("/address")
public class AddressController {
    private IAddressService addressService;

    @Autowired
    public AddressController(IAddressService AddressService){
        this.addressService=AddressService;
    }
    @GetMapping("")
    public List<Address> findAll() {
        return addressService.findAll();
    }
    @GetMapping("/{id}")
    public Address findById(@PathVariable long id) {
        return addressService.findById(id);
    }
}
