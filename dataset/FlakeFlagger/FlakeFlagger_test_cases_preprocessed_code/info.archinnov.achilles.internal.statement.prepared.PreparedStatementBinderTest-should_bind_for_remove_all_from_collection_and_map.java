@Test public void should_bind_for_remove_all_from_collection_and_map() throws Exception {
assertThat(asList(actual.getValues())).containsExactly(0,null,primaryKey);
}