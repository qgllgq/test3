package lgq.elasticsearch.demospringdata.service;

import lgq.elasticsearch.demospringdata.entity.Poem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PoemService {
    /**
     * 保存poem实体
     * @param poem
     */
    void save(Poem poem);

    /**
     * 基于title和content进行搜索，返回分页
     * @param title
     * @param content
     * @param pageable
     * @return
     */
    Page<Poem> search(String title, String content, Pageable pageable);

    Page<Poem> search(String content, Pageable pageable);

    /**
     * 返回所有数据集合
     * @param pageable
     * @return
     */
    Page<Poem> findAll(Pageable pageable);
}
