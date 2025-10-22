# JDBC

## Steps to follow to make a connection and run sql through Java:
- Before starting with the code:
  - Before coding anything, you will need to install the driver for your database for stablishing the connection in the `pom.xml` file. For example, for mysql:
    ```xml
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>9.4.0</version>
        </dependency>

        <dependency>
            <groupId>org.xerial</groupId>
            <artifactId>sqlite-jdbc</artifactId>
            <version>3.50.3.0</version>
        </dependency>
    ```


1. Start the db connection
   - For starting the db connection we need an instance of Connection, which comes from **java.sql.Connection**
     - For instancing this object, we don't use the new keyword, but be use a **factory method**. 
     - Example of connection to an embedded db:
         ```java
         Path dbPath = Path.of("src", "main", "resources", "db", "hogwarts.db");
         Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath.toString());
         ```
     - Example of connection to a remote db (in localhost in this case):
        ```java
        Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "MyRootPassword");
        ```
     
2. Once the connection has been established properly, you can start making your own queries. For doing this:
    - We will be using a **PreparedStatement** instance, created by another **factory method** from the Connection instance:
     ```java
     String sqlQuery = "SELECT * FROM Users WHERE id = ?;";
     PreparedStatement ps = cn.prepareStatement(consultaSQL);
     ```
    - If the query has any params (?), we must insert that data to the query in this way. Please do not put the values directly in the sqlQuery (security reasons, to prevent sql injection):
     ```java
     ps.setInt(1, 99);
     ```
    - Once the query is ready to be executed, we can store its response in a ResultSet:
     ```java
     ResultSet results = ps.executeQuery();
     ```
   - For making any INSERT / UPDATE / DELETE or any DML sentence (CREATE TABLE / UPDATE TABLE / DROP TABLE) we use **ps.executeUpdate()** instead of **ps.executeQuery()**

3. Once we have the instance of the ResultSet, we can get into the data itself by using the **results.next()** method in a while loop.
    - For accessing the information of each field itself we would use the **results.getString("fieldName") / results.getInt("fieldName")** depending on the type of the field
     ```java
       while (results.next()) {
            estudiantes.add(new Estudiante(
                    results.getInt("id_estudiante"),
                    results.getString("nombre"),
                    results.getString("apellido"),
                    results.getInt("año_curso"),
                    results.getString("fecha_nacimiento"),
                    results.getInt("id_casa")
            ));
        }
     ```
4. After interacting with the database, please also make sure to close the connection:
      ```java
       if (cn != null && !cn.isClosed()) {
            cn.close();
       }
      ```
   