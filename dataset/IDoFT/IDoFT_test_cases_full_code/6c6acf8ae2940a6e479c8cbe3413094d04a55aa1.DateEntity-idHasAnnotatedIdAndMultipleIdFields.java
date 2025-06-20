@Test void idHasAnnotatedIdAndMultipleIdFields(){
class Entity {
    @Id public String annotatedId="123";
    @Field("id") public String otherId0="456";
    @Field("id") public String otherId1="789";
  }
  Entity entity=new Entity();
  CouchbaseDocument converted=new CouchbaseDocument();
  converter.write(entity,converted);
  assertThat(converted.getId()).isEqualTo(entity.annotatedId);
}
