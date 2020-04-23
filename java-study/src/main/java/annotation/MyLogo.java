package annotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLogo {

    String type();
    String name() default "程序员爱酸奶";
    String url() default "quellanan.xyz";

}
