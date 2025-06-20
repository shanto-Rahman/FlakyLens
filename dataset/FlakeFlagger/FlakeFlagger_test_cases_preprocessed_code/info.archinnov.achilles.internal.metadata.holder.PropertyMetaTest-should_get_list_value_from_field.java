@Test public void should_get_list_value_from_field() throws Exception {
assertThat(pm.<String>getListValueFromField(entity)).containsExactly("foo","bar");
}