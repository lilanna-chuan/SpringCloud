package xyz.quellanan.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName LogoProperties
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/24 14:15
 * @Version 1.0
 */

@Getter
@Setter
@ConfigurationProperties(prefix = "logo")
public class LogoProperties {


    public static final String NAME="程序员爱酸奶";
    public static final String URL="xyz.quellanan";
    public static final String CONTENT="welcome !";

    @Value()
    private String name;
    private String url;
    private String content;
}
