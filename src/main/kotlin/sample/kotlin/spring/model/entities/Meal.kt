package sample.kotlin.spring.model.entities

import javax.persistence.Entity
import javax.validation.constraints.NotEmpty

@Entity
class Meal (@NotEmpty val name : String,
            val description: String?,
            val ingredients: Map<String, Int>?) : AbstractJpaPersistable<Long>()
