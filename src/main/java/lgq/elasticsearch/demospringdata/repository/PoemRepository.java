package lgq.elasticsearch.demospringdata.repository;

import lgq.elasticsearch.demospringdata.entity.Poem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoemRepository extends ElasticsearchRepository<Poem,Long> {

    Page<Poem> findByTitleLikeOrContentLike(String title,String content,Pageable pageable);

    Page<Poem> findByContentLike(String content, Pageable pageable);
}
