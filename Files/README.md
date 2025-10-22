# File management in Java

## Serializing and deserializing data (Currently not recommended)
For serializing an object directly in a `.dat` file, you should follow these steps:
  1. Implement the Serializable interface in your class to serialize
  2. Create the ObjectOutputStream instance that will write the serialized data:
       ```java
       File outputDataFile = new File("my/file/path/serializedObject.dat");
       FileOutputStream fos = new FileOutputStream(outputDataFile);
       ObjectOutputStream oos = new ObjectOutputStream(fos);
       MyOwnObject info = new MyOwnObject(); // The MyOwnObject class should implement Serializable
       oos.writeObject(info);
       oos.close();
       fos.close();
       ```

For deserializing this data:
1. Instead of creating an ObjectOutputStream instance, we create an ObjectInputStream:
    ```java
    File inputDataFile = new File("my/file/path/serializedObject.dat");
    FileInputStream fis = new FileInputStream(inputDataFile);
    ObjectInputStream ois = new ObjectInputStream(fis);
    ```
2. Then, we can directly read the object and convert it to the desired instance:
   ```java
   MyOwnObject info = (MyOwnObject) ois.readObject();
   // Do whatever needed with your instance (You can already work with it)
   ois.close();
   fis.close();
   ```

## Serializing and deserializing JSON files

First of all, both to serialize and deserialize the JSON files, we will be using the Jackson dependency in your pom.xml:
```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.20.0</version>
</dependency>
```

### Serialization
1. Once downloaded, you can start serializing your data. For doing so, we will be using an instance of the ObjectMapper class:
    ```java
    File f = new File(outputFilePath); // The outputFilePath should have the .json extension
    ObjectMapper om = new ObjectMapper();
    FileWriter fw = new FileWriter(f);
    BufferedWriter bw = new BufferedWriter(fw);
    
    MyOwnClass data = new MyOwnClass();
    String jsonString = om.writeValueAsString(data);

    bw.write(jsonString);

    bw.close();
    fw.close();
    ```
   - Note that for writing, we simply use a BufferedWriter instance, the ObjectMapper from Jackson only transforms the data to a String that will then have to be written to a file.

### Deserialization
For deserializing the data, the process will be similar:

1. Read the text from the file:
2. Collect the data to an ArrayNode:
3. Use a loop to collect each json object data and convert it to its Java intance:
    ```java
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);

    String jsonText = br.readLine(); // If the json is all in the same line

    ObjecMapper om = new ObjectMapper();

    ArrayNode jsonDeserialized = (ArrayNode) om.readTree(jsonText);
    List<MyOwnClass> myDataList = new List<>();
   for (int i = 0; i < jsonDeserialized.size(); i++) {
        JsonNode node = jsonDeserialized.get(i);
        MyOwnClass myData = new MyOwnClass(node.get("MyAttribute"));
        myDataList.add(myData);
    }
    ```


