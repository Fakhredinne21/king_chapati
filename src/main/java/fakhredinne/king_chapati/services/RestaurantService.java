package fakhredinne.king_chapati.services;


import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.models.Restaurant;
import fakhredinne.king_chapati.repository.MealRepository;
import fakhredinne.king_chapati.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MealRepository mealRepository;
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }
 /*   public List<Restaurant> findByLocation(String Location){
        return restaurantRepository.getRestaurantsByLocation(Location);
    }*/
    public void addMeal(Long id,Meal meal){
         meal.setRestaurant(findRestaurant(id));
         mealRepository.save(meal);
    }
    public Restaurant findRestaurant(Long id){
        return restaurantRepository.findRestaurantsByIdresturant(id);

    }






}
