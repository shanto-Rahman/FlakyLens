@Test void queryByExampleWithFirstnameOrLastname(){
  Person person=new Person();
  person.setFirstname("Frodo");
  person.setLastname("Baggins");
  ExampleMatcher matcher=matchingAny();
  Example<Person> example=Example.of(person,matcher);
  Query query=exampleMapper.getMappedExample(example);
  assertThat(query.getCriteria()).map(Object::toString).hasValue("(firstname = 'Frodo') OR (lastname = 'Baggins')");
}
