package projectspring.estudo.model.dblocal2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "id_email")
public class IdEmail {


        @Id
        @Column(name = "id")
        private Integer id;


        @Column(name = "email")
        private String email;


        public IdEmail(){

        }

        public IdEmail(Integer id, String email) {
                this.id = id;
                this.email = email;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        @Override
        public String toString() {
                return "IdEmail{" +
                        "id=" + id +
                        ", email='" + email + '\'' +
                        '}';
        }
}
