package com.akulinski.poolsapplication.core.components.entites.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "authority")
@Getter
@Setter
@NoArgsConstructor
public class AuthorityEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_authority")
    private Integer id;

    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id_user")
    private UserEntity userEntity;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @Column(name = "date_of_modification")
    private Date dateOfModification;

    @PrePersist
    protected void onCreate() {
        dateOfCreation = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        dateOfModification = new Date();
    }


}
