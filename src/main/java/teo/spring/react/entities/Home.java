package teo.spring.react.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long homeId;
    private String name;
    private String area;
    private String eidos;
    private Long tm;
    private Long year;
    private String url;
    private Long phone;
    private Date dateToVisit;
    private String comments;
    private boolean liked;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users users;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Home )) return false;
        return homeId != null && homeId.equals(((Home) o).getHomeId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

}
