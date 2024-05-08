package fakhredinne.king_chapati.repository;

import fakhredinne.king_chapati.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findAdminByEmail(String email);

}
