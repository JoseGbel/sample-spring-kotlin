/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package sample.kotlin.spring

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import sample.kotlin.spring.model.entities.Meal
import sample.kotlin.spring.model.repository.MealRepository


@SpringBootApplication
open class WhatIsInMyFridge {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(WhatIsInMyFridge::class.java)
        }
    }

    @Bean
    open fun bCryptPasswordEncoder() : BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    open fun sampleData(repository : MealRepository): CommandLineRunner{
        val gaduIngredients = HashMap<String, Int>()
        val paellaIngredients = HashMap<String, Int>()
        val redCurryIngredients = HashMap<String, Int>()

        gaduIngredients["Rice"] = 200
        gaduIngredients["Butternut Squash"] = 100

        paellaIngredients["Rice"] = 200
        paellaIngredients["Mussels"] = 100

        redCurryIngredients["Rice"] = 200
        redCurryIngredients.put("Coconut Milk", 100)

        return CommandLineRunner {
            repository.save(Meal("Gadu gadu", "Indonesian rice", gaduIngredients))
            repository.save(Meal("Paella", "Spanish rice", paellaIngredients))
            repository.save(Meal("Thai red curry", "Thai rice", redCurryIngredients))
        }
    }
}
