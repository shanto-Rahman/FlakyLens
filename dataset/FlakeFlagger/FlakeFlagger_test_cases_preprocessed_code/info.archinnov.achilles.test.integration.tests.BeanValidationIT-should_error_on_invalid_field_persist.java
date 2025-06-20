@Test public void should_error_on_invalid_field_persist() throws Exception {
assertThat(ex.getMessage()).contains(errorMessage.toString());
assertThat(exceptionRaised).isTrue();
}