package resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

/**
 * 访问 远程服务器资源时，可以通过UrlResource进行访问
 * 资源采用特殊的编码格式时，可以通过EncodedResource对资源进行编码。
 */
public class EncodedResourceExample {
    public static void main(String[] args) throws Throwable {
        Resource res = new ClassPathResource("resource/test.txt");
        EncodedResource encodedRes = new EncodedResource(res, "UTF-8");
        String content = FileCopyUtils.copyToString(encodedRes.getReader());
        System.out.println(content);
    }
}
