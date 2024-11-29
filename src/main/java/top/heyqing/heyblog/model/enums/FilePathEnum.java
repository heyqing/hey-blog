package top.heyqing.heyblog.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName:FilePathEnum
 * Package:top.heyqing.heyblog.model.enums
 * Description:
 * 文件存储路径枚举类
 *
 * @Date:2024/11/29
 * @Author:Heyqing
 */
@Getter
@AllArgsConstructor
public enum FilePathEnum {

    AVATAR("heyqing/hey_blog/avatar/", "头像路径"),

    ARTICLE("heyqing/hey_blog/articles/", "文章图片路径"),

    VOICE("heyqing/hey_blog/voice/", "音频路径"),

    PHOTO("heyqing/hey_blog/photos/", "相册路径"),

    CONFIG("heyqing/hey_blog/config/", "配置图片路径"),

    TALK("heyqing/hey_blog/talks/", "配置图片路径"),

    MD("heyqing/hey_blog/markdown/", "md文件路径");

    private final String path;

    private final String desc;

}

