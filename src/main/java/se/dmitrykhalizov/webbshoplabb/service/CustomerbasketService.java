package se.dmitrykhalizov.webbshoplabb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.entity.Customerbasket;
import se.dmitrykhalizov.webbshoplabb.repository.CustomerbasketRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerbasketService {

    private final CustomerbasketRepo customerbasketRepo;

    @Autowired
    public CustomerbasketService(CustomerbasketRepo customerbasketRepo) {
        this.customerbasketRepo = customerbasketRepo;
    }

    public Customerbasket createCustomerbasket(Customerbasket customerbasket) {
        return customerbasketRepo.save(customerbasket);
    }

    public List<Customerbasket> getAllCustomerbaskets() {
        return customerbasketRepo.findAll();
    }

    public Customerbasket updateCustomerbasket(Customerbasket customerbasket) {
        return customerbasketRepo.save(customerbasket);
    }

    public void deleteCustomerbasket(int id) {
        customerbasketRepo.deleteById(id);
    }

    public Optional<Customerbasket> getCustomerbasketById(int id) {
        return customerbasketRepo.findById(id);
    }


}
