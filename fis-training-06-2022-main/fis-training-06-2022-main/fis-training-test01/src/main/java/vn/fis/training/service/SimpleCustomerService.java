package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.exception.CustomerNotFoundException;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.exception.InvalidCustomerException;
import vn.fis.training.store.InMemoryCustomerStore;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService{

    private InMemoryCustomerStore customerStore;
    List<Customer> listCustomer = new ArrayList<>(customerStore.findAll());

    @Override
    public Customer findById(String id) throws InvalidCustomerException{
        if (isNullOrEmpty(id)){
            throw new IllegalArgumentException("Khong the tim voi id loi");
        }
            for (Customer c: listCustomer) {
                if (c.getId()==(id)) {
                    return c;
                }
            }
        throw new  CustomerNotFoundException("Khong tim thay");
    }
    private boolean isNullOrEmpty(String id) {
        if(id==null) return false;
        if(id.trim().length() == 0) return false;
        return true;
    }
    @Override
    public Customer createCustomer(Customer customer) {
        checkCustomer(customer);
        validate(customer);
        customerStore.insertOrUpdate(customer);
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return null;
    }
    private void validate(Customer customer) {
        if(isNullOrEmpty(customer.getId())){
            throw new InvalidCustomerException("Customer ID is empty");
        }
        if(isNullOrEmpty(customer.getMobile())){
            throw new InvalidCustomerException("Customer Mobile is empty");
        }
        if(isNullOrEmpty(customer.getName())){
            throw new InvalidCustomerException("Customer Name is empty");
        }
        if(isNullOrEmpty(String.valueOf(customer.getBirthDay()))){
            throw new InvalidCustomerException("Customer Birth Day is empty");
        }
        if(isNullOrEmpty(String.valueOf(customer.getStatus()))){
            throw new InvalidCustomerException("Customer Status is empty");
        }


    }
    private void checkCustomer(Customer customer) {
    if(customerStore.findAll().stream()
            .filter(customer1 -> customer1.getMobile().equals(customer.getMobile())).findFirst().isPresent()){
        throw new DuplicateCustomerException(customer,"Customer with phone number " + customer.getMobile() + "is duplicated");
    }
    }
    @Override
    public Customer updateCustomer(Customer customer) {
        checkCustomer(customer);
        validate(customer);
        customerStore.insertOrUpdate(customer);
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return null;
    }

    @Override
    public void deleteCustomerById(String id) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return customerStore
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return  customerStore
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Customer::getName))
                .limit(limit)
                .collect(Collectors.toList());
    }
    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, int limit) {
        return customerStore
                .findAll()
                .stream()
                .filter(customer -> customer.getName().equals(custName))
                .sorted(Comparator.comparing(Customer::getName))
                .limit(limit)
                .collect(Collectors.toList());

    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {

        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return summaryCustomerByAgeOrderByAgeDesc()
                .stream()
                .sorted(Comparator.comparing(SummaryCustomerByAgeDTO::getAge))
                .collect(Collectors.toList());
    }

}
