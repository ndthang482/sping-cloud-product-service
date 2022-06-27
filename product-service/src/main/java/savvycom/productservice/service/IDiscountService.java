package savvycom.productservice.service;

import savvycom.productservice.domain.model.entity.Discount;

import java.util.List;

public interface IDiscountService {
    Discount save(Discount discount);

    void delete(Long id);

    List<Discount> findAll();

    Discount findById(Long id);

    List<Discount> findByDiscountUnder30(String discountPercent);

    List<Discount> findByDiscount30to50(String discountPercent);
    List<Discount> findByDiscountAbove50(String discountPercent);
}
