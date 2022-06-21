package savvycom.productservice.service.impl;

import org.springframework.stereotype.Service;
import savvycom.productservice.domain.entity.Branch;
import savvycom.productservice.repository.BranchRepository;
import savvycom.productservice.service.IBranchService;

import java.util.List;

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
    public Branch findById(long id) {
        return (Branch) branchRepository.findById(id).orElse(null);
    }
}