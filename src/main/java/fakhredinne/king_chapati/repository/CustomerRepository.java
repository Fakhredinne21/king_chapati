package fakhredinne.king_chapati.repository;

import fakhredinne.king_chapati.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
public Customer findByEmail(String email);
public Customer findByUsername(String username);
public Customer findByUsernameAndPassword(String username, String password);
public Customer findByEmailAndPassword(String email, String password);
public void deleteByUsername(String username);



}
