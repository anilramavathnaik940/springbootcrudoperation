package spring_crud.demo_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_crud.demo_app.model.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
