package top.heyqing.heyblog.strategy.context;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.heyqing.heyblog.strategy.UploadStrategy;

import java.io.InputStream;
import java.util.Map;

import static top.heyqing.heyblog.model.enums.UploadModeEnum.getStrategy;

/**
 * ClassName:UploadStrategyContext
 * Package:top.heyqing.heyblog.strategy.context
 * Description:
 *
 * @Date:2024/11/30
 * @Author:Heyqing
 */
@Service
public class UploadStrategyContext {

    @Value("${upload.mode}")
    private String uploadMode;

    @Autowired
    private Map<String, UploadStrategy> uploadStrategyMap;

    public String executeUploadStrategy(MultipartFile file, String path) {
        return uploadStrategyMap.get(getStrategy(uploadMode)).uploadFile(file, path);
    }

    public String executeUploadStrategy(String fileName, InputStream inputStream, String path) {
        return uploadStrategyMap.get(getStrategy(uploadMode)).uploadFile(fileName, inputStream, path);
    }

}

