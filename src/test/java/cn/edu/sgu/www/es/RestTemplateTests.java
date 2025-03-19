package cn.edu.sgu.www.es;

import cn.edu.sgu.www.es.es.entity.Song;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author heyunlin
 * @version 1.0
 */
@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class RestTemplateTests {

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void test() {
        SearchHits<Song> search = elasticsearchRestTemplate.search(Query.findAll(), Song.class);
        List<SearchHit<Song>> searchHits = search.getSearchHits();

        for (SearchHit<Song> searchHit : searchHits) {
            System.out.println(searchHit);
        }
    }

    @Test
    public void testIndexOps() {
        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(Song.class);

        System.out.println(indexOperations.exists());
    }

}
