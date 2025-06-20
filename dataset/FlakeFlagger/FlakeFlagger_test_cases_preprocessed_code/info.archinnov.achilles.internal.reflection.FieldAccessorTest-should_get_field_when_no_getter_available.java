@Test public void should_get_field_when_no_getter_available() throws Exception {
assertThat(accessor.getValueFromField(nameField,instance)).isEqualTo("name");
}