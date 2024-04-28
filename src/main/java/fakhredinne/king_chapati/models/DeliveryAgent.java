package fakhredinne.king_chapati.models;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DeliveryAgent")
public class DeliveryAgent extends User{
    private String status;
}
