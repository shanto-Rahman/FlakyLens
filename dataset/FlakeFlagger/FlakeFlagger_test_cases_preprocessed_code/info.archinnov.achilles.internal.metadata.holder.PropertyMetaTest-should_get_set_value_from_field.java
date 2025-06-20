@Test public void should_get_set_value_from_field() throws Exception {
assertThat(pm.<String>getSetValueFromField(entity)).containsOnly("George","Paul");
}