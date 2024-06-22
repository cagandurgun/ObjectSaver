_
# ObjectRecord

## In this README:
- [Overview](#overview) provides a brief description of what the project does.
- [Features](#features) lists the functionalities of the `ObjectRecord` class.
- [Usage](#usage) section demonstrates how to use the `saveObject` and `getObject` methods.
- [Author](#author) credits the author of the code.

### Overview
The ObjectRecord class is a utility in Java for saving objects to files and restoring them during runtime. This allows any Serializable object to be serialized and stored in a file, and later deserialized to recreate the object in memory.

### Features
- **Serialization**: Save any Serializable object to a file.
- **Deserialization**: Restore objects from previously saved files.
- **Exception Handling**: Throws `NotSerializableException` if an object does not implement the `Serializable` interface.
- **Usage**: Provides simple methods `saveObject` and `getObject` to interact with serialized files.

### Usage
#### Example of Creating a Suitable Object
If an object is not Serializable, the registration process cannot proceed successfully. Therefore, a NotSerializableException is thrown to ensure robust and reliable system operation, providing a descriptive message that indicates the class responsible for the issue. To avoid this situation, the only requirement is to implement the Serializable interface for the class you intend to register. Below, you can see an example of its usage in a simple class.

```java
import java.io.Serializable;

public class Car implements Serializable {
    String name;
    String color;

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
```

#### Saving an Object
The saving process for the Car class, as defined above and implementing the Serializable interface, can be performed simply as follows.

```java
Car car = new Car("Opel", "White");
String fileName = "file.path";
try {
    new ObjectRecord().saveObject(car, fileName);
} catch (NotSerializableException e) {
    throw new RuntimeException(e);
}
```

#### Restoring an Object
Similarly, restoring operations can be done simply as follows, just like saving processes.

```java
Car car;
String fileName = "file.path";
try {
    car = (Car) new ObjectRecord().getObject(fileName);
} catch (NotSerializableException e) {
    throw new RuntimeException(e);
}

System.out.println(car.name);
System.out.println(car.color);
```
### Author
Author: Çağan Durgun
