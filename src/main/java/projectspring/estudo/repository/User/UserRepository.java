package projectspring.estudo.repository.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projectspring.estudo.model.Usuario.Usuario;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <Usuario,Integer> {

    @Query (value = "SELECT * FROM Usuario", nativeQuery = true)
    List<Usuario> listaDeUsuario();
}
