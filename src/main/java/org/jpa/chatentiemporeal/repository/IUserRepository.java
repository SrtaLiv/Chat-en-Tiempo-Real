package org.jpa.chatentiemporeal.repository;

import org.jpa.chatentiemporeal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
