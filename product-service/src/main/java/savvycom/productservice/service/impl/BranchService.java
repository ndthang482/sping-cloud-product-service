package savvycom.productservice.service.impl;
//@Service hold the business handling code in it

import org.springframework.stereotype.Service;
import savvycom.productservice.domain.entity.Branch;
import savvycom.productservice.domain.entity.product.Category;
import savvycom.productservice.domain.entity.product.Inventory;
import savvycom.productservice.repository.BranchRepository;
import savvycom.productservice.repository.product.InventoryRepository;
import savvycom.productservice.service.IBranchService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchService implements IBranchService {
    private BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public void delete(Long id) {
        branchRepository.deleteById(id);
    }

    @Override
    public List<Branch> findAll() {
        return (List<Branch>) branchRepository.findAll();
    }

    @Override
    public Branch findById(Long id) {
        return (Branch) branchRepository.findById(id).orElse(null);
    }

}
