package fakhredinne.king_chapati.services;

import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MealService {

    @Autowired
    MealRepository mealRepository;
    public List<Meal> findAll() {
        return mealRepository.findAll();
    }


    public Meal findById(Long restaurantId) {
        return mealRepository.findById(restaurantId).get();
    }
}
