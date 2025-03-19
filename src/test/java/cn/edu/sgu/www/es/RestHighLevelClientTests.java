package cn.edu.sgu.www.es;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * springboot测试类
 * @author heyunlin
 * @version 1.0
 */
@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class RestHighLevelClientTests {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void test() throws IOException {
        DeleteRequest songs = Requests.deleteRequest("songs");

        songs.id("2023");

        DeleteResponse deleteResponse = restHighLevelClient.delete(songs, RequestOptions.DEFAULT);

        int status = deleteResponse.status().getStatus();

        System.out.println(status);
    }

}
