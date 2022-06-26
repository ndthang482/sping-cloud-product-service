package savvycom.productservice.service;

import savvycom.productservice.domain.entity.Branch;
import savvycom.productservice.domain.entity.product.Category;
import savvycom.productservice.domain.entity.product.Inventory;

import java.util.List;

public interface IBranchService {
    Branch save(Branch branch);

    void delete(Long id);

    List<Branch> findAll();

    Branch findById(Long id);
}
