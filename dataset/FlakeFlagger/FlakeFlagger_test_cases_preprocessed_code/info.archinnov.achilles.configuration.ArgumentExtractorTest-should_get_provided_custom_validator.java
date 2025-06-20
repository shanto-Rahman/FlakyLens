@Test public void should_get_provided_custom_validator() throws Exception {
assertThat(validator).isNotNull();
assertThat(validator).isSameAs(customValidator);
}