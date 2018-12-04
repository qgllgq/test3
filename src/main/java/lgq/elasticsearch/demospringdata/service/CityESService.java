package lgq.elasticsearch.demospringdata.service;

import lgq.elasticsearch.demospringdata.entity.Entity;

import java.util.List;

public interface CityESService {
    Long saveEntity(Entity entity);

    List<Entity> searchEntity(int pageNumber, int pageSize, String searchContent);

}
