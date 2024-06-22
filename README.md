
# ObjectRecord

### In this README:

- [Overview](#overview) provides a brief description of what the project does.
- [Features](#features) lists the functionalities of the `ObjectRecord` class.
- [Usage](#usage) section demonstrates how to use the `saveObject` and `getObject` methods.
- [Example](#example) section gives a sample code snippet demonstrating usage and exception handling.
- [Author](#author) credits the author of the code.

## Overview

The ObjectRecord class is a utility in Java for saving objects to files and restoring them during runtime. This allows any Serializable object to be serialized and stored in a file, and later deserialized to recreate the object in memory.

## Features

- **Serialization**: Save any Serializable object to a file.
- **Deserialization**: Restore objects from previously saved files.
- **Exception Handling**: Throws `NotSerializableException` if an object does not implement the `Serializable` interface.
- **Usage**: Provides simple methods `saveObject` and `getObject` to interact with serialized files.

## Usage

### Saving an Object

To save an object to a file:

```java
Object object = ...; // your object to save
String fileName = "file.path"; // path to the file
new ObjectRecord().saveObject(object, fileName);
```
### Restoring an Object
To restore an object from a file:

```java
String fileName = "file.path"; // path to the saved file
Object object = new ObjectRecord().getObject(fileName);
```

### Exception Handling
If an object is not Serializable, a NotSerializableException is thrown with a descriptive message indicating the class name that caused the issue.

```java
public static void main(String[] args) {
    try {
        // Saving an object
        Object objectToSave = new MySerializableObject();
        String fileName = "saved_object.dat";
        new ObjectRecord().saveObject(objectToSave, fileName);

        // Retrieving the object
        Object retrievedObject = new ObjectRecord().getObject(fileName);
        System.out.println("Object retrieved: " + retrievedObject);
    } catch (NotSerializableException e) {
        System.err.println("Object could not be saved or retrieved: " + e.getMessage());
    }
}
```
###  Author
Author: Çağan Durgun
