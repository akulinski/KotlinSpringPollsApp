package com.akulinski.poolsapplication.core.components.entites

import javax.persistence.*

@Entity
@Table(name = "option")
class OptionEntity {

    constructor() {}

    constructor(optionValue: String?) {
        this.optionValue = optionValue
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_option")
    private var _id: Int? = null

    var id: Int?
        get() {
            return _id
        }
        set(value) {
            _id = value
        }


    @Column(name = "value")
    private var _optionValue: String? = null

    var optionValue: String?
        get() {
            return _optionValue
        }
        set(value) {
            _optionValue = value
        }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id_pool")
    private var _poolEntity: PoolEntity? = null

    var poolEntity: PoolEntity?
        get() {
            return poolEntity
        }
        set(value) {
            _poolEntity = value
        }
}