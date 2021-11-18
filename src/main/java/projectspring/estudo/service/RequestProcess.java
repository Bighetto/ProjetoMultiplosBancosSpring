package projectspring.estudo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import projectspring.estudo.model.Usuario.Usuario;
import projectspring.estudo.repository.User.UserRepository;
import projectspring.estudo.repository.dblocal2.IdEmailRepository;
import projectspring.estudo.repository.dblocal2.NamePasswordRepository;

import java.util.List;

@Service
public class RequestProcess {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final NamePasswordRepository namePasswordRepository;
    @Autowired
    private final IdEmailRepository idEmailRepository;

    public RequestProcess(UserRepository userRepository, NamePasswordRepository namePasswordRepository, IdEmailRepository idEmailRepository) {
        this.userRepository = userRepository;
        this.namePasswordRepository = namePasswordRepository;
        this.idEmailRepository = idEmailRepository;
    }

    public void process(){

        try {

            List<Usuario> list = userRepository.listaDeUsuario();

            if (list.size() > 0){

            list.forEach(usuario -> {

            namePasswordRepository.insertTable(usuario.getName(),usuario.getPassword());

            idEmailRepository.insertTable(usuario.getId_user(),usuario.getEmail());

            });

            }

        } catch (Exception e){
            e.printStackTrace();

        }
    }

}
