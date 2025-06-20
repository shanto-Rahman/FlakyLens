@Test public void should_bind_for_add_elements_to_map_with_timestamp() throws Exception {
assertThat(asList(actual.getValues())).containsExactly(0,100L,values,primaryKey);
}