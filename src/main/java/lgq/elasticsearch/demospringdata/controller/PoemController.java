package lgq.elasticsearch.demospringdata.controller;

import lgq.elasticsearch.demospringdata.entity.Poem;
import lgq.elasticsearch.demospringdata.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/poem")
public class PoemController {

    @Autowired
    private PoemService poemService;

    /**
     * 插入数据
     * @return
     */
    @RequestMapping("/")
    public String index(){
        List<Poem> poems = new ArrayList<>();
        poems.add(new Poem(4l,"湘春夜月·近清明","近清明,翠禽枝上消魂,可惜一片清歌，都付与黄昏。欲共柳花低诉，怕柳花轻薄，不解伤春。念楚乡旅宿，柔情别绪，谁与温存。"));
        poems.add(new Poem(5l,"卜算子·不是爱风尘","不是爱风尘，似被前缘误。花落花开自有时，总赖东君主。\n" +
                "去也终须去，住也如何住！若得山花插满头，莫问奴归处"));
        poems.add(new Poem(6l,"御街行·秋日怀旧","纷纷坠叶飘香砌。夜寂静，寒声碎。真珠帘卷玉楼空，天淡银河垂地。年年今夜，月华如练，长是人千里。"));

        for(int i=0;i<poems.size();i++){
            poemService.save(poems.get(i));
        }
        return "ok";

    }

    @RequestMapping("/tt")
    public List<Poem> index1(
            @RequestParam(value = "pageIndex",defaultValue = "0",required = false) int pageIndex,
            @RequestParam(value = "pageSize",required = false, defaultValue = "10") int pageSize){
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<Poem> poems = poemService.findAll(pageable);
        List<Poem> content = poems.getContent();
        return content;
    }

    @RequestMapping("/t")
    public List<Poem> index2(
            @RequestParam(value = "content",defaultValue = "风",required = false)  String content,
            @RequestParam(value = "pageIndex",defaultValue = "0",required = false) int pageIndex,
            @RequestParam(value = "pageSize",required = false, defaultValue = "10") int pageSize){
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<Poem> list = poemService.search(content, pageable);
        List<Poem> listContent = list.getContent();
        return listContent;
    }

    @RequestMapping("/like")
    public List<Poem> search(
            @RequestParam(value = "title",defaultValue = "近",required = false)  String title,
            @RequestParam(value = "content",defaultValue = "风",required = false)  String content,
            @RequestParam(value = "pageIndex",defaultValue = "0",required = false) int pageIndex,
            @RequestParam(value = "pageSize",required = false, defaultValue = "10") int pageSize){
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<Poem> poems = poemService.search(title, content, pageable);
        List<Poem> list = poems.getContent();
        return list;
    }

}
