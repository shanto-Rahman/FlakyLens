@Test public void should_return_default_validator() throws Exception {
assertThat(defaultValidator).isNotNull().isInstanceOf(ValidatorImpl.class);
}