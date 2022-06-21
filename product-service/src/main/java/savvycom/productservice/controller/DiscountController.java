package savvycom.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import savvycom.productservice.domain.entity.Discount;
import savvycom.productservice.service.IDiscountService;

import java.util.List;

@RestController
@RequestMapping("/discount")
public class DiscountController {
    private IDiscountService discountService;

    @Autowired
    public DiscountController(IDiscountService DiscountService){
        this.discountService=DiscountService;
    }
    @GetMapping("")
    public List<Discount> findAll() {
        return discountService.findAll();
    }
    @GetMapping("/{id}")
    public Discount findById(@PathVariable long id) {
        return discountService.findById(id);
    }
}
