# Learning MongoDB with Spring

1. MongoDB collections, documents and fields:
    - Instead of tables, a MongoDB database stores its data in **collections**. A collection holds one or more BSON documents. **Documents** are analogous to records or rows in a relational database table. Each document has one or more **fields**; fields are similar to the columns in a relational database table.

2. Business Model Annotations:
    1. \@Document (this annotation of the class level will give the name of the **collection**
    2. \@Id (gives unique id for each **document**)

3. Mongo Repository:
    - Should create class that will extends MongoRepository<class_name, id_data_type> (class_name - must be the collection name that we will pass throught this repository, and the id_data_type must be the data type of the id in that document), same as JPA configuration and usage.

4. Indexes (speed up the query requests to find specific field and guarantee uniqueness of the field):
    1. \@Indexed(unique = true) - it is used in the field of the document and it specifies unique index which will be used for serch
    2. In application.properties shoud add <br/>
        spring.data.mongodb.auto-index-creation=true // enable the creation of indexes

5. MongoTemplates and Queries:
    1. Query object - is used to create criteria query for database
    2. inject MongoTemplate object - mongoTemplate.find(Query_Object, Retrun_Class_Name.class);

6. Customr Queries form method name:
    1. In the MongoRepository class will create a new method
    2. Just write the name and everething will work for example findStudentByEmail(Struden email);
    3. If we want a custom query abouve the method shoud use \@Query("") annotation

7. CRUD operations with API Layer everything is the same as it is in relational database

