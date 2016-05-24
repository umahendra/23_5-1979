<html>
<body>
<h2>Hello World!</h2>


<!-- 
@Id - applied at the field level to mark the field used for identiy purpose.
@Document - applied at the class level to indicate this class is a candidate for mapping to the database. You can specify the name of the collection where the database will be stored.
@DBRef - applied at the field to indicate it is to be stored using a com.mongodb.DBRef.
@Indexed - applied at the field level to describe how to index the field.
@CompoundIndex - applied at the type level to declare Compound Indexes
@GeoSpatialIndexed - applied at the field level to describe how to geoindex the field.
@Transient - by default all private fields are mapped to the document, this annotation excludes the field where it is applied from being stored in the database
@PersistenceConstructor - marks a given constructor - even a package protected one - to use when instantiating the object from the database. Constructor arguments are mapped by name to the key values in the retrieved DBObject.
@Value - this annotation is part of the Spring Framework . Within the mapping framework it can be applied to constructor arguments. This lets you use a Spring Expression Language statement to transform a key's value retrieved in the database before it is used to construct a domain object.
@Field - applied at the field level and described the name of the field as it will be represented in the MongoDB BSON document thus allowing the name to be different than the fieldname of the class.
	  
-->

</body>
</html>
