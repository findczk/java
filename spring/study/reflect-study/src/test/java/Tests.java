import org.junit.Test;

import java.lang.reflect.*;

/**
 * @author dsx
 */
public class Tests {
    @Test
    public void typeTest() {
        Class<Foo> fooClass = Foo.class;



        Field[] declaredFields = fooClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Type genericType = declaredField.getGenericType();
            if (genericType instanceof ParameterizedType) {
                System.out.println("ParameterizedType:" + genericType);

                ParameterizedType parameterizedType = (ParameterizedType) genericType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    String typeName = actualTypeArgument.getTypeName();
                    System.out.println(typeName);
                    if (actualTypeArgument instanceof WildcardType) {
                        System.out.println("WildcardType:" + actualTypeArgument);
                    }
                }

            }
            if (genericType instanceof TypeVariable) {
                System.out.println("TypeVariable:" + genericType);
            }
            if (genericType instanceof GenericArrayType) {
                System.out.println("GenericArrayType:" + genericType);
            }
            if (genericType instanceof WildcardType) {
                System.out.println("WildcardType:" + genericType);
            }
            if (genericType instanceof Class) {
                System.out.println("Class:" + genericType);

            }

        }
    }
}
