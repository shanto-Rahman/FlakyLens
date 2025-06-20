@Test void idHasMultiplePrefixesAndSuffixesSameOrder(){
class Entity {
    @GeneratedValue(strategy=GenerationStrategy.USE_ATTRIBUTES) @Id public String id;
    @IdAttribute public String someId="abc";
    @IdPrefix(order=1) public String prefix="111";
    @IdPrefix(order=1) public String prefix1="333";
    @IdSuffix(order=1) public String suffix1="444";
    @IdSuffix(order=1) public String suffix="222";
  }
  Entity entity=new Entity();
  CouchbaseDocument converted=new CouchbaseDocument();
  converter.write(entity,converted);
  assertThat(converted.getId()).isEqualTo(entity.id);
  assertThat(converted.getId()).isEqualTo(entity.prefix1 + '.' + entity.someId+ '.'+ entity.suffix);
}
