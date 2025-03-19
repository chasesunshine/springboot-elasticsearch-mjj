package cn.edu.sgu.www.es.es.repository;

import cn.edu.sgu.www.es.es.entity.Song;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author heyunlin
 * @version 1.0
 */

/**
 * ElasticsearchRepository<T, ID>
 *
 * T：表示实体类型（Entity Type），即与 Elasticsearch 文档映射的 Java 类。
 * ID：表示实体主键的类型，通常是 String 或 Long。
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
