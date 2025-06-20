/** 
 * @see #27
 * @throws Exception
 */
@Test void inlinesContent() throws Exception {
  Person person=new Person();
  person.firstname="Dave";
  person.lastname="Matthews";
  EntityModel<Person> resource=EntityModel.of(person);
  resource.add(Link.of("localhost"));
  assertThat(write(resource)).isEqualTo(REFERENCE);
}
