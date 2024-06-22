/*
 * This code was written by Çağan Durgun.
 */

import java.io.*;

/**
 * The ObjectRecord class is a utility in the Java programming language that allows
 * objects to be saved to files and restored from files. Using this class, you can
 * save any object and later recreate it during the runtime of your program.
 */
public class ObjectRecord {

    /**
     * This method saves a given object to a specified file. The object is serialized
     * and written to the file. If the object has not implemented the Serializable
     * interface, a NotSerializableException is thrown.
     * <p>To save any object:
     * <pre> {@code
     * Object object = null;
     * String fileName = "file.path";
     * new ObjectRecord().saveObject(object, fileName);
     *     } </pre>
     * A similar structure should be used.
     */
    public void saveObject(Object object, String file) throws NotSerializableException {
        if (checkSerializable(object)) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
                objectOutputStream.writeObject(object);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new NotSerializableException("Save failed. \u001B[34m"
                    + object.getClass().getSimpleName() +
                    "\u001B[0m class is not Serializable.");
        }
    }

    /**
     * This method restores an object from a specified file. The data read from the
     * file is deserialized and returned as an object. If the restored object has not
     * implemented the Serializable interface, a NotSerializableException is thrown.
     * <p>To restart a saved object:
     * <pre> {@code
     * String fileName = "file.path";
     * Object object = (Object) new ObjectRecord().getObject(fileName);
     *     } </pre>
     * A similar structure should be used.
     */
    public Object getObject(String file) throws NotSerializableException {
        Object object = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            object = objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("error: " + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (object != null) {
            if (checkSerializable(object)) {
                return object;
            } else {
                throw new NotSerializableException("Load failed. \u001B[34m"
                        + object.getClass().getSimpleName() +
                        "\u001B[0m class is not Serializable.");
            }
        } else return null;
    }

    /**
     * checkSerializable(Object object): This method checks whether a given object
     * has implemented the Serializable interface. If the object has implemented the
     * Serializable interface, it returns true; otherwise, it returns false.
     */
    private boolean checkSerializable(Object object) {
        boolean shouldProceed = false;
        Class<?>[] interfaces = object.getClass().getInterfaces();
        for (Class<?> inter : interfaces) {
            if (inter.getName().contains("Serializable")) {
                shouldProceed = true;
                break;
            }
        }
        return shouldProceed;
    }
}