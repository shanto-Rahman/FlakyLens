@Test void queryByExampleSupportsPropertyTransforms(){
if (o.isPresent()) {
}
if (o.isPresent()) {
}
assertThat(query.getCriteria()).map(Object::toString).hasValue("(firstname = 'FRODO') AND (lastname = 'baggins') AND (secret = 'I have the ring!')");
}