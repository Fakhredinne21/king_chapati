package fakhredinne.king_chapati.services;


import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.models.Restaurant;
import fakhredinne.king_chapati.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    public void addMeal(long restaurantId,Meal meal){

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("Restaurant not found"));
        meal.setRestaurant(restaurant);
        restaurant.getMeals().add(meal);

        restaurantRepository.save(restaurant);


    }

    public Restaurant findRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }


}
