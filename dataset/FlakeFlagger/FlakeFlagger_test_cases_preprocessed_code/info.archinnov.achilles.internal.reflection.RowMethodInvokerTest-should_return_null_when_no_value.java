@Test public void should_return_null_when_no_value() throws Exception {
assertThat(invoker.invokeOnRowForFields(row,pm)).isNull();
}