@Test void queryByExampleWithNullMatchingFirstnameAndLastname(){
  Person person=new Person();
  person.setFirstname("Bilbo");
  person.setLastname("Baggins");
  ExampleMatcher matcher=matching().withIncludeNullValues();
  Example<Person> example=Example.of(person,matcher);
  Query query=exampleMapper.getMappedExample(example);
  assertThat(query.getCriteria()).map(Object::toString).hasValue("(firstname IS NULL OR firstname = 'Bilbo') AND (lastname IS NULL OR lastname = 'Baggins')");
}
