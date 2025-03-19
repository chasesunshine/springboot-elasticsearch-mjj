package cn.edu.sgu.www.es.repository;

import cn.edu.sgu.www.es.entity.Song;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyunlin
 * @version 1.0
 */
@Repository
public interface SongRepository extends ElasticsearchRepository<Song, String> {

}
