package the.garis.bigf.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "big_f", name = "topic_type")
public class TopicType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
