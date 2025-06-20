@Test void queryByExampleEvenHandlesInvisibleFields(){
assertThat(query.getCriteria()).map(Object::toString).hasValue("(firstname = 'Frodo') AND (secret = 'I have the ring!')");
}