@Test public void should_get_string_value_from_row() throws Exception {
assertThat(method.invoke(row,"name")).isEqualTo("value");
}