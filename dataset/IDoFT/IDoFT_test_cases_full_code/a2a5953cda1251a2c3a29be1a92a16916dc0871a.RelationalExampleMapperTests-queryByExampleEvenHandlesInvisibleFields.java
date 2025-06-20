@Test void queryByExampleEvenHandlesInvisibleFields(){
  Person person=new Person();
  person.setFirstname("Frodo");
  person.setSecret("I have the ring!");
  Example<Person> example=Example.of(person);
  Query query=exampleMapper.getMappedExample(example);
  assertThat(query.getCriteria()).map(Object::toString).hasValue("(firstname = 'Frodo') AND (secret = 'I have the ring!')");
}
