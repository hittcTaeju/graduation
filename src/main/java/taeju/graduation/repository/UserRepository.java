package taeju.graduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taeju.graduation.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

}
