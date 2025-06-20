@Test public void should_error_on_invalid_class_persist() throws Exception {
assertThat(ex.getMessage()).contains(errorMessage.toString());
assertThat(exceptionRaised).isTrue();
}