@Test public void should_persist_and_find() throws Exception {
assertThat(found.getContent()).isEqualTo("this is a tweet");
assertThat(found.getOriginalAuthorId()).isEqualTo(userId);
assertThat(found.getIsARetweet()).isFalse();
}