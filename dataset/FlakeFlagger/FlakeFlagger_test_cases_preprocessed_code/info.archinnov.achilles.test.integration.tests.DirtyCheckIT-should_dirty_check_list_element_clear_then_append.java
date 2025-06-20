@Test public void should_dirty_check_list_element_clear_then_append() throws Exception {
assertThat(row.getList("friends",String.class)).containsExactly("qux");
}