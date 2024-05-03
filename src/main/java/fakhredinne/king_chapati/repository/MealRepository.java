package fakhredinne.king_chapati.repository;

import fakhredinne.king_chapati.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    public List<Meal> findAll();
}
