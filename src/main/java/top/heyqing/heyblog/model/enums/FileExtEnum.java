package top.heyqing.heyblog.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName:FileExtEnum
 * Package:top.heyqing.heyblog.model.enums
 * Description:
 * 文件后缀枚举类
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Getter
@AllArgsConstructor
public enum FileExtEnum {

    JPG(".jpg", "jpg文件"),

    PNG(".png", "png文件"),

    JPEG(".jpeg", "jpeg文件"),

    WAV(".wav", "wav文件"),

    MD(".md", "markdown文件"),

    TXT(".txt", "txt文件");

    public static FileExtEnum getFileExt(String extName) {
        for (FileExtEnum value : FileExtEnum.values()) {
            if (value.getExtName().equalsIgnoreCase(extName)) {
                return value;
            }
        }
        return null;
    }

    private final String extName;

    private final String desc;

}

