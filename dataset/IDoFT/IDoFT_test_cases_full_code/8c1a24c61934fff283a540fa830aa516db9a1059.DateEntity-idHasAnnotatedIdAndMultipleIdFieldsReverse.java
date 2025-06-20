@Test void idHasAnnotatedIdAndMultipleIdFieldsReverse(){
class Entity {
    @Field("id") public String otherId0="456";
    @Field("id") public String otherId1="789";
    @Id public String annotatedId="123";
  }
  Entity entity=new Entity();
  CouchbaseDocument converted=new CouchbaseDocument();
  assertThatExceptionOfType(MappingException.class).isThrownBy(() -> {
    converter.write(entity,converted);
  }
);
}
