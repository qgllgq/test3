package lgq.elasticsearch.demospringdata.service;

import lgq.elasticsearch.demospringdata.entity.Poem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PoemService {
    /**
     * 保存poem实体
     * @param poem 参数
     */
    void save(Poem poem);

    /**
     * 基于title和content进行搜索，返回分页
     * @param title 标题
     * @param content 内容
     * @param pageable 分页
     * @return 返回值
     */
    Page<Poem> search(String title, String content, Pageable pageable);

    Page<Poem> search(String content, Pageable pageable);

    /**
     * 返回所有数据集合
     * @param pageable 分页
     * @return 返回值
     */
    Page<Poem> findAll(Pageable pageable);
}
