package xyz.quellanan.annotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SelfLogo {

    String name() default "程序员爱酸奶";
    String url() default "quellanan.xyz";
    String content() default "welcome !";

}
