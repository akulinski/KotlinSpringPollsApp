package com.akulinski.poolsapplication.core.components.entites

import com.akulinski.poolsapplication.core.components.entites.users.UserEntity
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "pool")
class PoolEntity {

    constructor() {}

    constructor(title: String?) {
        this._title = title
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pool")
    private var _id: Int? = null

    var id: Int?
        get() {
            return _id
        }
        set(value) {
            _id = value
        }

    @Column(name = "title", nullable = false)
    private var _title: String? = null

    var title: String?
        get() {
            return _title
        }
        set(value) {
            _title = value
        }

    @Column(name = "date_of_creation")
    private var dateOfCreation: Date? = null
        get() {
            return dateOfCreation
        }

    @Column(name = "date_of_modification")
    private var dateOfModification: Date? = null
        get() {
            return dateOfModification
        }

    @Fetch(FetchMode.SELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "_poolEntity")
    private var options: Set<OptionEntity>? = null
        get() {
            return options
        }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id_user")
    private var _userEntity: UserEntity? = null

    var userEntity: UserEntity?
        get() {
            return _userEntity
        }
        set(value) {
            _userEntity = value
        }

    @PrePersist
    private fun onCreate() {
        dateOfCreation = Date()
    }

    @PreUpdate
    private fun onUpdate() {
        dateOfModification = Date()
    }


}