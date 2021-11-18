package projectspring.estudo.repository.dblocal2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import projectspring.estudo.model.dblocal2.IdEmail;

public interface IdEmailRepository extends JpaRepository<IdEmail, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into id_email (id , email ) values (:id, :email)", nativeQuery = true)
    void insertTable(@Param("id")Integer id,
                     @Param("email")String email);

}
