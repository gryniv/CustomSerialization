package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import user.User;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ByteSerializationTest {
    private static final Logger LOG = LogManager.getLogger(ByteSerializationTest.class);
    private final ByteSerialization<Integer[]> intArraySerialization = new ByteSerialization<>();
    private final ByteSerialization<String[]> stringArraySerialization = new ByteSerialization<>();
    private final ByteSerialization<Integer> intSerialization = new ByteSerialization<>();
    private final ByteSerialization<String> stringSerialization = new ByteSerialization<>();
    private final ByteSerialization<User> userSerialization = new ByteSerialization<>();
    private Integer[] integers;
    private String[] strings;

    @Before
    public void setUp() {
        this.integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        this.strings = new String[]{"a", "b", "c", "d", "e", "f", "g"};
    }

    @Test
    void shouldSerializeIntegerArrayToByteArray() {
        byte[] intArrayInBytes = intArraySerialization.byteSerialize(integers);
        Integer[] bytesToIntArray = intArraySerialization.byteDeserializer(intArrayInBytes);
        assertArrayEquals(bytesToIntArray, integers);
    }

    @Test
    void shouldSerializeStringArrayToByteArray() {
        byte[] stringArrayInBytes = stringArraySerialization.byteSerialize(strings);
        String[] intArray = stringArraySerialization.byteDeserializer(stringArrayInBytes);
        assertArrayEquals(intArray, strings);
    }

    @Test
    void shouldSerializeIntToByteArray() {
        int integer = 1;
        byte[] intInBytes = intSerialization.byteSerialize(integer);
        int integerDeserialized = intSerialization.byteDeserializer(intInBytes);
        assertEquals(integerDeserialized, 1);
    }

    @Test
    void shouldSerializeStringToByteArray() {
        String string = "Hello world!";
        byte[] stringInBytes = stringSerialization.byteSerialize(string);
        String stringDeserialized = stringSerialization.byteDeserializer(stringInBytes);
        assertEquals(stringDeserialized, "Hello world!");
    }

    @Test
    void shouldSerializeUserToByteArray() {
        User user = new User();
        user.setName("Ihor");
        user.setLastName("Gryniv");
        byte[] userInBytes = userSerialization.byteSerialize(user);
        User userDeserialized = userSerialization.byteDeserializer(userInBytes);
        assertEquals(userDeserialized.getName(), "Ihor");
        assertEquals(userDeserialized.getLastName(), "Gryniv");
    }
}