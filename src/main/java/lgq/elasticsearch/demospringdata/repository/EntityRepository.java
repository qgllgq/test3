package lgq.elasticsearch.demospringdata.repository;

import lgq.elasticsearch.demospringdata.entity.Entity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * es操作类
 */
public interface EntityRepository extends ElasticsearchRepository<Entity,Long> {

}
