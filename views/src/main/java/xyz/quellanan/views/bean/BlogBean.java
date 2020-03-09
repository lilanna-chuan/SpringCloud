package xyz.quellanan.views.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName BlogBean
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/8 18:56
 * @Version 1.0
 */
@Setter
@Getter
public class BlogBean {
    String titleArticle;
    String articleType;
    String url;
    int readCount;

    public BlogBean(String titleArticle,String articleType,int readCount){
        this.titleArticle=titleArticle;
        this.articleType=articleType;
        this.readCount=readCount;
    }
}
