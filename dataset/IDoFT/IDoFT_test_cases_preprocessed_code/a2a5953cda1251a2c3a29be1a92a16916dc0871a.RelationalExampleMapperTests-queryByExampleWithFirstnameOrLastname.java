@Test void queryByExampleWithFirstnameOrLastname(){
assertThat(query.getCriteria()).map(Object::toString).hasValue("(firstname = 'Frodo') OR (lastname = 'Baggins')");
}