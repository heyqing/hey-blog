package top.heyqing.heyblog.strategy;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * ClassName:UploadStrategy
 * Package:top.heyqing.heyblog.strategy
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
public interface UploadStrategy {

    String uploadFile(MultipartFile file, String path);

    String uploadFile(String fileName, InputStream inputStream, String path);

}

