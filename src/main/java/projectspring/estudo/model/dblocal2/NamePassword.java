package projectspring.estudo.model.dblocal2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "name_password")
public class NamePassword {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    public NamePassword(){

    }

    public NamePassword(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "NamePassword{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
