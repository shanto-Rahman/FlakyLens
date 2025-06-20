@Test public void should_dirty_check_simple_property() throws Exception {
assertThat(reloadedName).isEqualTo("another_name");
}