@Test public void should_update_list_at_index_with_cas_condition() throws Exception {
assertThat(actual.getFriends()).containsExactly("Helen");
}