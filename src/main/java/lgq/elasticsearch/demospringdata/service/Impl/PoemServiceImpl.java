package lgq.elasticsearch.demospringdata.service.Impl;

import lgq.elasticsearch.demospringdata.entity.Poem;
import lgq.elasticsearch.demospringdata.repository.PoemRepository;
import lgq.elasticsearch.demospringdata.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PoemServiceImpl implements PoemService {

    @Autowired
    private PoemRepository poemRepository;

    @Override
    public void save(Poem poem) {
        poemRepository.save(poem);
    }

    @Override
    public Page<Poem> search(String title, String content, Pageable pageable) {
        return poemRepository.findByTitleLikeOrContentLike(title,content,pageable);
    }

    @Override
    public Page<Poem> search(String content, Pageable pageable) {
        return poemRepository.findByContentLike(content,pageable);
    }

    @Override
    public Page<Poem> findAll(Pageable pageable) {
        return poemRepository.findAll(pageable);
    }
}
