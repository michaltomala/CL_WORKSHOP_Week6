package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.User;

//todo sprawdzić czy napewno Long
public interface UserRepository extends JpaRepository<User, Long>{

}

