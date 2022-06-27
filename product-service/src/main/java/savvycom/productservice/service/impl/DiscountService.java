package savvycom.productservice.service.impl;
//@Service hold the business handling code in it

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import savvycom.productservice.domain.model.entity.Discount;
import savvycom.productservice.repository.DiscountRepository;
import savvycom.productservice.service.IDiscountService;

import java.util.List;

@Service
public class DiscountService implements IDiscountService {
    @Autowired
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
    public Discount findById(Long id) {
        return discountRepository.findById(id).orElse(null);
    }

    @Override
    public List<Discount> findByDiscountUnder30(String discountPercent) {
        return discountRepository.findByDiscountUnder30(discountPercent);
    }

    @Override
    public List<Discount> findByDiscount30to50(String discountPercent) {
        return discountRepository.findByDiscount30to50(discountPercent);
    }

    @Override
    public List<Discount> findByDiscountAbove50(String discountPercent) {
        return discountRepository.findByDiscountAbove50(discountPercent);
    }

}
