@Test void queryByExampleSupportsPropertyTransforms(){
  Person person=new Person();
  person.setFirstname("Frodo");
  person.setLastname("Baggins");
  person.setSecret("I have the ring!");
  ExampleMatcher matcher=matching().withTransformer("firstname",o -> {
    if (o.isPresent()) {
      return o.map(o1 -> ((String)o1).toUpperCase());
    }
    return o;
  }
).withTransformer("lastname",o -> {
    if (o.isPresent()) {
      return o.map(o1 -> ((String)o1).toLowerCase());
    }
    return o;
  }
);
  Example<Person> example=Example.of(person,matcher);
  Query query=exampleMapper.getMappedExample(example);
  assertThat(query.getCriteria()).map(Object::toString).hasValue("(firstname = 'FRODO') AND (lastname = 'baggins') AND (secret = 'I have the ring!')");
}
