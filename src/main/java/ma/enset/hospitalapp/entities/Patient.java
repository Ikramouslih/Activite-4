package ma.enset.hospitalapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity // JPA entity : cette classe correspond à une table dans la BD
//Lombok Annotations : ajouter implecitement les getters & setters, Constructor avec et sans parameteres
@Data @NoArgsConstructor @AllArgsConstructor
@Builder //Utiliser pour finaliser la construction d'un objet complexe

public class Patient {
    @Id //Id de l'entity JPA : signifie que cet attribut est l'id de l'entity et le primary key de la table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id s'incremente automatiquement
    private Long id;
    @NotEmpty//Des annotations pour la validation
    @Size(min = 4, max = 20)
    private String nom;
    @Temporal(TemporalType.DATE)//Utiliser la date seulement, sans le temps
    private Date dateNaissance;

    private boolean malade;

    @Min(10) //La valeur minimal possible de cet attribut est 10
    private int score;
}

//ORM : le mapping objet relationnel => une technique qui associe une classe à une table de la BD,
//afin de programmer avec un seul langage et éviter SQL;
//Se fait par les annotations JPA, Spring data ou les fichiers XML.

//Hibernate : Un framework ORM qui établie la connection avec la BD implecitement sans écrire beaucoup de lignes de code.

//JPA (Java persistent API) : une api avec des interfaces, classes abstraites et des annotations qui standarisent l'ORM
//permet à l'application d'être independante du framework ORM.
//dispose des methodes classiques pour intéragir avec la BD.
//inclue EntityManagerFactory, EntityManager, EntityTransaction

//Classe persistente : ses objets sont stockés dans une DB ou XML ...


