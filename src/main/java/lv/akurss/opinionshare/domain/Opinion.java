package lv.akurss.opinionshare.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@SequenceGenerator(name = "seq_gen", sequenceName = "opinions_seq")
@Entity
@Table(name = "opinions")
public class Opinion {
    @Id
    @GeneratedValue(generator = "seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "created", nullable = false)
    private LocalDateTime created = LocalDateTime.now();
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated = LocalDateTime.now();
    @Column(name = "version", nullable = false)
    @Version
    private Long version;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "rating")
    private Integer rating = 0;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Opinion() {
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", version=" + version +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", topic=" + topic +
                '}';
    }
}
