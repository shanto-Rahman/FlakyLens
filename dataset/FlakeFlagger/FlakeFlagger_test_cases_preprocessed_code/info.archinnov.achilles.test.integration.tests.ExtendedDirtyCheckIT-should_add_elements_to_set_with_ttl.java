@Test public void should_add_elements_to_set_with_ttl() throws Exception {
Thread.sleep(1000);
assertThat(bean.getFollowers()).containsOnly("George","Paul");
}