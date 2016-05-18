package headfirst.proxy.javaproxy;

import java.lang.reflect.*;
/**
 * Created by igors on 16.04.16.
 */
public class NonOwnerInvocationHandler2 implements InvocationHandler {
    PersonBean personBean;

    public NonOwnerInvocationHandler2(PersonBean personBean){
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            if (method.getName().startsWith("get")) {
                return method.invoke(personBean, args);
            }else if(method.getName().equals("setHotOrNotRating")){
                return method.invoke(personBean, args);
            }else if(method.getName().startsWith("set")){
                throw new IllegalAccessException("Not-owner user may not change profile of another user");
            }
        }catch(InvocationTargetException e){
            e.printStackTrace();
        }
        return null;
    }
}
