@Test public void should_add_elements_to_list_with_ttl() throws Exception {
Thread.sleep(1000);
assertThat(bean.getFriends()).containsExactly("foo","bar");
}