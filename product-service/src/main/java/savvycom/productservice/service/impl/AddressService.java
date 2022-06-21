package savvycom.productservice.service.impl;

import org.springframework.stereotype.Service;
import savvycom.productservice.domain.entity.Address;
import savvycom.productservice.repository.AddressRepository;
import savvycom.productservice.service.IAddressService;

import java.util.List;

@Service
public class AddressService implements IAddressService {
    private AddressRepository addressRepository;
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> findAll() {
        return (List<Address>) addressRepository.findAll();
    }
    @Override
    public Address findById(long id) {
        return (Address) addressRepository.findById(id).orElse(null);
    }
}
