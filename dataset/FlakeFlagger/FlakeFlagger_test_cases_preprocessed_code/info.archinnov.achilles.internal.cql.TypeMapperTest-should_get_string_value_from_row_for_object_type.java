@Test public void should_get_string_value_from_row_for_object_type() throws Exception {
assertThat(method.invoke(row,"object")).isEqualTo("object_value");
}