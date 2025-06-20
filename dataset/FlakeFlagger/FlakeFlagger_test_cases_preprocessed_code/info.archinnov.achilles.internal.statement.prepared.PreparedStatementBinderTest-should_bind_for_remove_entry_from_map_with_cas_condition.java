@Test public void should_bind_for_remove_entry_from_map_with_cas_condition() throws Exception {
assertThat(asList(actual.getValues())).containsExactly(0,1,null,primaryKey,"John");
}