package be.thomasmore.bookserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Shop {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String shopName;
}
