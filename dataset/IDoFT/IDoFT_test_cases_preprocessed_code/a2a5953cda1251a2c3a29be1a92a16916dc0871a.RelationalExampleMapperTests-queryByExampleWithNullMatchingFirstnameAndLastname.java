@Test void queryByExampleWithNullMatchingFirstnameAndLastname(){
assertThat(query.getCriteria()).map(Object::toString).hasValue("(firstname IS NULL OR firstname = 'Bilbo') AND (lastname IS NULL OR lastname = 'Baggins')");
}