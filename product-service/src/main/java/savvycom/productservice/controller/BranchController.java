package savvycom.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import savvycom.productservice.domain.entity.Branch;
import savvycom.productservice.service.IBranchService;

import java.util.List;
@RestController
@RequestMapping("/branch")
public class BranchController {
    private IBranchService branchService;

    @Autowired
    public BranchController(IBranchService BranchService){
        this.branchService=BranchService;
    }
    @GetMapping("")
    public List<Branch> findAll() {
        return branchService.findAll();
    }
    @GetMapping("/{id}")
    public Branch findById(@PathVariable long id) {
        return branchService.findById(id);
    }
}
