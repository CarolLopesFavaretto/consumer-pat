package br.com.alelo.consumer.consumerpat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(unique = true)
    private int documentNumber;
    private Date birthDate;
    @Embedded
    private Contacts contacts;
    @Embedded
    private Address address;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cards> cards;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumer consumer = (Consumer) o;
        return documentNumber == consumer.documentNumber
                && Objects.equals(id, consumer.id)
                && Objects.equals(name, consumer.name)
                && Objects.equals(birthDate, consumer.birthDate)
                && Objects.equals(contacts, consumer.contacts)
                && Objects.equals(address, consumer.address);
    }
}
