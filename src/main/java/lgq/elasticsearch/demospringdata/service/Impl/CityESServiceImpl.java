package lgq.elasticsearch.demospringdata.service.Impl;

import lgq.elasticsearch.demospringdata.entity.Entity;
import lgq.elasticsearch.demospringdata.repository.EntityRepository;
import lgq.elasticsearch.demospringdata.service.CityESService;

import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;

import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.facet.FacetRequest;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CityESServiceImpl implements CityESService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityESServiceImpl.class);

    int PAGE_SIZE = 15; //默认分页大小

    int PAGE_NUMBER = 0; //默认当前页

    String SCORE_MODE_SUM = "sum"; //权重分球和模式

    Float MIN_SCORE = 10.0F; //由于无相关性的分值默认为1， 设置权重分最小值为10

    @Autowired
    EntityRepository entityRepository;

    /**
     * 保存到es
     *
     * @param entity
     * @return
     */
    @Override
    public Long saveEntity(Entity entity) {
        Entity result = entityRepository.save(entity);
        return result.getId();
    }

    /**
     * 在es中查询
     *
     * @param pageNumber
     * @param pageSize
     * @param searchContent
     * @return
     */
    @Override
    public List<Entity> searchEntity(int pageNumber, int pageSize, String searchContent) {
        if (pageSize == 0) {
            pageSize = PAGE_SIZE;
        }
        if (pageNumber < 0) {
            pageNumber = PAGE_NUMBER;
        }

        SearchQuery searchQuery = getEntitySearchQuery(pageNumber, pageSize, searchContent);
        Page<Entity> page = entityRepository.search(searchQuery);

        return page.getContent();
    }

    /**
     * 组装搜索Query对象
     *
     * @param pageNumber
     * @param pageSize
     * @param searchContent
     * @return
     */
    private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
        final FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders
                .functionScoreQuery(QueryBuilders.commonTermsQuery("name", searchContent),
                        ScoreFunctionBuilders.weightFactorFunction(1000));
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        return new NativeSearchQueryBuilder().withPageable(pageable).withQuery(functionScoreQueryBuilder).build();
    }
}
