package guo.ping.e3mall.manager.mapper;

import guo.ping.e3mall.common.utils.FastDFSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class FastDFSTest {

    @Test
    public void testFastDfsClient() throws Exception {
        FastDFSClient fastDFSClient = new FastDFSClient("/Users/jbi/workspace/springframework/e3-springboot/e3-manager/e3-manager-web/src/main/resources/conf/fastdfs-client.conf");
        String file = fastDFSClient.uploadFile("/Users/jbi/Documents/my-me/photoes/郑州园博园20171029/WechatIMG207.jpeg");
        System.out.println(file);
    }

}
