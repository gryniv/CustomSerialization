package service;

import java.io.IOException;

public interface Serialization<T> {

    /**
     * @return Object serialized to byte array
     * @apiNote work with any (simple and complex, that contains
     * objects fields, primitives, collections and etc.) objects
     */
    byte[] serialize(T t) throws IOException;

    /**
     * @return byte array deserialize to Object
     * @apiNote work with any (simple and complex, that contains
     * objects fields, primitives, collections and etc.) objects
     */
    T deserializer(byte[] arr);

}
