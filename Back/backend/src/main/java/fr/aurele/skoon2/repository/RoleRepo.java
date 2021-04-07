package fr.aurele.skoon2.repository;

import fr.aurele.skoon2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
