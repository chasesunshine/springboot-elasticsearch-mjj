package cn.edu.sgu.www.es.es.repository;

import cn.edu.sgu.www.es.es.entity.Song;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author heyunlin
 * @version 1.0
 */
@Repository
public interface SongRepository extends ElasticsearchRepository<Song, String> {

    /**
     * 通过歌曲名查询歌曲列表
     * @param name 歌曲名
     * @return List<Song>
     */
    List<Song> findByName(String name);
}
