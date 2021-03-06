package sample.kotlin.spring.user

import org.springframework.data.jpa.repository.JpaRepository


interface ApplicationUserRepository : JpaRepository<ApplicationUser?, Long?> {
    fun findByUsername(username: String?): ApplicationUser?
}