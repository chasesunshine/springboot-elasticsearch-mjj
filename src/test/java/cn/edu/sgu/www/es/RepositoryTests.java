package cn.edu.sgu.www.es;

import cn.edu.sgu.www.es.es.entity.Song;
import cn.edu.sgu.www.es.es.repository.SongRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * springboot测试类
 * @author heyunlin
 * @version 1.0
 */
@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class RepositoryTests {

    @Resource
    private SongRepository songRepository;

    @Test
    public void testFindByName() {
        List<Song> list = songRepository.findByName("雨爱");

        System.out.println("共查询到" + list.size() + "条记录。");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (Song song : list) {
            System.out.println(song);
        }
    }

    @Test
    public void testSave() {
        Song song = new Song();

        song.setId("2023");
        song.setName("雨爱");
        song.setNote("雨爱");

        Song save = songRepository.save(song);

        System.out.println("save = " + save);
    }

    @Test
    public void testDelete() {
        Song song = new Song();

        song.setId("2023");
        song.setName("雨爱");
        song.setNote("雨爱");

        songRepository.delete(song);
    }

    @Test
    public void testDeleteById() {
        testSave();
        testFindByName();

        songRepository.deleteById("2023");

        testFindByName();
    }

    @Test
    public void testDeleteAll() {
        songRepository.deleteAll();
    }

    @Test
    public void testExistsById() {
        boolean exists = songRepository.existsById("2023");

        if (!exists) {
            System.out.println("记录不存在");
        }
    }

    @Test
    public void testFindById() {
        testSave();

        Optional<Song> optional = songRepository.findById("2023");

        if (optional.isPresent()) {
            Song song = optional.get();

            System.out.println(song);
        }
    }

    @Test
    public void testCount() {
        long count = songRepository.count();

        System.out.println(count);
    }

}
