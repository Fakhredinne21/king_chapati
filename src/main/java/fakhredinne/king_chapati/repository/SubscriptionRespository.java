package fakhredinne.king_chapati.repository;

import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRespository extends JpaRepository<Subscription, Long> {

}
