package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/23 19:14
 * @Version 1.0
 */
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
