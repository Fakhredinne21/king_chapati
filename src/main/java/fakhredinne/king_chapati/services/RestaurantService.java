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
    public Restaurant findRestaurant(Long id){
        return restaurantRepository.findRestaurantsByIdUser(id);

    }
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }
 /*   public List<Restaurant> findByLocation(String Location){
        return restaurantRepository.getRestaurantsByLocation(Location);
    }*/
    public List<Meal>getMeal(Long id){
        return mealRepository.getByRestaurant(findRestaurant(id));
    }
    public void addMeal(Meal meal){
        mealRepository.save(meal);
    }
    public void deleteMeal(Meal meal){
        mealRepository.delete(meal);

    }






}
