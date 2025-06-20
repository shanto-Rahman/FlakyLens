@Test public void should_get_value_from_null_field() throws Exception {
assertThat(invoker.getValueFromField(null,field)).isNull();
}