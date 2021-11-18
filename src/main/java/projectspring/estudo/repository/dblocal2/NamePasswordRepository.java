package projectspring.estudo.repository.dblocal2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import projectspring.estudo.model.dblocal2.NamePassword;

public interface NamePasswordRepository extends JpaRepository<NamePassword, String> {

    @Transactional
    @Modifying
    @Query(value = "insert into name_password (name, password ) values (:name, :password)", nativeQuery = true)
    void insertTable(@Param("name")String name,
                     @Param("password")String password);


}
