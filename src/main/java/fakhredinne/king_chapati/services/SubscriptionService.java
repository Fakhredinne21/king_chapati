package fakhredinne.king_chapati.services;

import fakhredinne.king_chapati.models.Subscription;
import fakhredinne.king_chapati.repository.SubscriptionRespository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import java.util.List;
@Service
public class SubscriptionService {
    @Autowired
    SubscriptionRespository subscriptionRespository;
     public List<Subscription> findAllSubscription(){

        return subscriptionRespository.findAll();
    }

}
