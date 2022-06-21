package savvycom.productservice.service.impl;

import org.springframework.stereotype.Service;
import savvycom.productservice.domain.entity.Discount;
import savvycom.productservice.repository.DiscountRepository;
import savvycom.productservice.service.IDiscountService;

import java.util.List;

@Service
public class DiscountService implements IDiscountService {
    private DiscountRepository discountRepository;
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public Discount save(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public void delete(Long id) {
        discountRepository.deleteById(id);
    }

    @Override
    public List<Discount> findAll() {
        return (List<Discount>) discountRepository.findAll();
    }
    @Override
    public Discount findById(long id) {
        return (Discount) discountRepository.findById(id).orElse(null);
    }
}
