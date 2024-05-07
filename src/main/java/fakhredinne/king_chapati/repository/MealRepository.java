package fakhredinne.king_chapati.repository;

import fakhredinne.king_chapati.models.Category;
import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
     List<Meal> findAll();
     List<Meal> getMealByCat(Category cat);
     List <Meal> getMealByDescription(String description);
     List<Meal> getByName(String name);
     List <Meal> getByRestaurant(Restaurant res);


}
