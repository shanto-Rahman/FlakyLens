@Test public void should_add_elements_to_list_with_timestamp() throws Exception {
assertThat(bean.getFriends()).containsExactly("foo","bar");
}