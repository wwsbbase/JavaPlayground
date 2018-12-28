import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("ClassLoaderTest main");

        DiskClassLoader diskLoader = new DiskClassLoader("../lib");
        try {
            Class c = diskLoader.loadClass("com.wwsb.testClassLoader.Test");

            if(c != null){
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("say",null);
                    method.invoke(obj, null);
                } catch (InstantiationException | IllegalAccessException 
                        | NoSuchMethodException
                        | SecurityException | 
                        IllegalArgumentException | 
                        InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
