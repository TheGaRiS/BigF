package the.garis.bigf.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "big_f", name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "topic_type_id")
    private Long topicTypeId;
}
