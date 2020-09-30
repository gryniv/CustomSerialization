package service;

import java.io.*;

public class ByteSerialization<T> implements Serialization<T> {

    @Override
    public byte[] serialize(T t) {
        byte[] result = null;
        ByteArrayOutputStream stream = null;
        try {
            stream = new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(stream);
            o.writeObject(t);
            result = stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public T deserializer(byte[] array) {
        InputStream stream = null;
        try {
            stream = new ByteArrayInputStream(array);
            ObjectInputStream o = new ObjectInputStream(stream);
            T t = (T) o.readObject();
            return t;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}