package teo.spring.react.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long HomeId;

    private String name;
    private String url;
    private int phone;
    private Date dateToVisit;
    private boolean liked;

}
