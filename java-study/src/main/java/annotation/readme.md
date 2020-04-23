# 注解
从Java7 开始，Java一共只有10个注解。4个元注解就是前面的 。

## 4大元注解
@Documented

@Retention

@Inherited

@Target

### @Documented
 表示这个会被javadoc 工具类标记，做使用这个注解的类或者方法生成注释。是一个标记注解，没有成员。
 
 源码：
```
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Documented {
}
```

### @Target
@Target  用于描述注解的使用范围
```
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Target {
    /**
     * Returns an array of the kinds of elements an annotation type
     * can be applied to.
     * @return an array of the kinds of elements an annotation type
     * can be applied to
     */
    ElementType[] value();
}
```
其中枚举类ElmentType的源码如下
```
public enum ElementType {
    /描述类、接口、enum声明/
    TYPE,
    /描述域(includes enum constants) /
    FIELD,
    /描述方法*/
    METHOD,
    /描述参数 */
    PARAMETER,
    /描述构造器*/
    CONSTRUCTOR,

    /描述局部变量 */
    LOCAL_VARIABLE,

    /注释类型声明 */
    ANNOTATION_TYPE,
    /包 */
    PACKAGE,

    /** 类型参数声明
     * Type parameter declaration
     * @since 1.8
     */
    TYPE_PARAMETER,
    /**使用类型声明
     * Use of a type
     * @since 1.8
     */
    TYPE_USE
}
```

可以看到@Target 源码里写了一个自己的注解
`@Target(ElementType.ANNOTATION_TYPE)  表明@Target 本身是一个注解类型。`


### @Retention 

@Retention 表明需要在什么级别保存该注释信息。表示注解在什么范围内有效。

```
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Retention {
    /**
     * Returns the retention policy.
     * @return the retention policy
     */
    RetentionPolicy value();
}
```
其中RetentionPolicy 枚举类中的源码：
```
public enum RetentionPolicy {
       /**在源文件中有效（即源文件保留）*/
       SOURCE,
       /**class文件中保留*/
       CLASS,
       /**在运行时保留*/
       RUNTIME
   }
```

### @Inherited  
@Inherited  是一种标记注解，表明允许子类继承父类注解。

```
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Inherited {
}
```

# 其他注解
1、@Override，用的比较多，在子类重写父类方法的时候必须使用，否则会编译报错。  

2、@Deprecated 是表示已经过时的方法，不推荐使用。如果使用该方法，编译时会提示警告信息。  

3、@SuppressWarning 表示忽略警告信息

下面这三个注解用的比较少  
4、@SafeVarargs 忽略任何使用参数为泛型变量的方法或构造函数调用产生的警告

5、@FunctionalInterface - Java 8 开始支持，标识一个匿名函数或函数式接口。

6、@Repeatable - Java 8 开始支持，标识某注解可以在同一个声明上使用多次。



# 自定义注解

```

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLogo {

    String type();
    String name() default "程序员爱酸奶";
    String url() default "quellanan.xyz";

}
```

demo
```
public class Solution {


    public static void main(String[] args) {
        Solution solution= new Solution();
        solution.helle();
    }

    @MyLogo(type = "1111")
    public void helle(){
        Class oo=Solution.class;
        Method[] methods=oo.getMethods();
        for(Method method:methods){
            if("helle".trim().equals(method.getName())){
                Annotation mylogo=method.getAnnotation(MyLogo.class);
                System.out.println(((MyLogo) mylogo).name());
                System.out.println(((MyLogo) mylogo).type());
                System.out.println(((MyLogo) mylogo).url());
            }
        }

    }
}
```






















