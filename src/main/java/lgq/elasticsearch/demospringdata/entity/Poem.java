package lgq.elasticsearch.demospringdata.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "poem", type = "poem", shards = 1, replicas = 0)
public class Poem implements Serializable {

    private static final long serialVersionUID = -763638353551774167L;

    @Id
    private Long id;

    private String title;

    private String content;

    public Poem(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Poem(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Poem(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
