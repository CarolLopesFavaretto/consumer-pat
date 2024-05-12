package br.com.alelo.consumer.consumerpat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Extract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private int establishmentNameId;

    @Column(nullable = false)
    private String establishmentName;

    @Column(nullable = false)
    private String productDescription;

    @Column(nullable = false)
    private Date dateBuy;

    @ManyToOne
    @JoinColumn(name = "cardId", referencedColumnName = "id", nullable = false)
    private Card card;

    @Column(nullable = false)
    private double amount;

//    public Extract(int id, int establishmentNameId, String establishmentName, String productDescription, Date dateBuy, int cardNumber, double amount) {
//        this.id = id;
//        this.establishmentNameId = establishmentNameId;
//        this.establishmentName = establishmentName;
//        this.productDescription = productDescription;
//        this.dateBuy = dateBuy;
//        this.amount = amount;
//    }
//
//    public Extract(String productDescription, Date dateBuy, int cardNumber, double amount) {
//        this.productDescription = productDescription;
//        this.dateBuy = dateBuy;
//        this.amount = amount;
//    }
//
//    public Extract(String establishmentName, String productDescription, Date dateBuy, int cardNumber, double amount) {
//        this.establishmentNameId = establishmentNameId;
//        this.establishmentName = establishmentName;
//        this.productDescription = productDescription;
//        this.dateBuy = dateBuy;
//        this.amount = amount;
//    }

}
