package service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class ByteSerialization<T> {

    public byte[] byteSerialize(T t) {
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

    public T byteDeserializer(byte[] array) {
        InputStream stream = null;
        try {
            stream = new ByteArrayInputStream(array);
            ObjectInputStream o = new ObjectInputStream(stream);
            T t = (T) o.readObject();
            return t;
        } catch (IOException | ClassNotFoundException e) {
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
        return null;
    }
}