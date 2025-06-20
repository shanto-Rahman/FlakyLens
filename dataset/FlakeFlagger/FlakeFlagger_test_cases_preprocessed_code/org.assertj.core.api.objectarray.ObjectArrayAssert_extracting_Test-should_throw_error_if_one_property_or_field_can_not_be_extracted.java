@Test public void should_throw_error_if_one_property_or_field_can_not_be_extracted() throws Exception {
assertThat(employees).extracting("unknown","age","id").containsOnly(tuple("Yoda",800,1L),tuple("Luke",26,2L));//RW
}