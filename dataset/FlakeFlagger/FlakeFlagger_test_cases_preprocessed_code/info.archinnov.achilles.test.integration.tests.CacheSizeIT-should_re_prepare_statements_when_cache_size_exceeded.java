@Test public void should_re_prepare_statements_when_cache_size_exceeded() throws Exception {
assertThat(found.getAge()).isEqualTo(11L);
assertThat(found.getName()).isEqualTo("name");
assertThat(found.getFriends()).containsExactly("foo","bar");
assertThat(found.getFollowers()).containsOnly("George","Paul");
}