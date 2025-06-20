@Test public void should_get_value_from_field() throws Exception {
assertThat(pm.getValueFromField(entity)).isEqualTo("name");
}