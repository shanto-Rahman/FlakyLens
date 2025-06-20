@Test void queryByExampleWithFirstnameAndLastname(){
  Person person=new Person();
  person.setFirstname("Frodo");
  person.setLastname("Baggins");
  Example<Person> example=Example.of(person);
  Query query=exampleMapper.getMappedExample(example);
  assertThat(query.getCriteria()).map(Object::toString).hasValue("(firstname = 'Frodo') AND (lastname = 'Baggins')");
}
