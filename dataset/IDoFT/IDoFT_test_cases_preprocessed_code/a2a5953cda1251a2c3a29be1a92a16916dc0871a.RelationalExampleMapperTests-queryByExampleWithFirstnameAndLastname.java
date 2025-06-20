@Test void queryByExampleWithFirstnameAndLastname(){
assertThat(query.getCriteria()).map(Object::toString).hasValue("(firstname = 'Frodo') AND (lastname = 'Baggins')");
}