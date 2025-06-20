@Test public void should_refresh() throws Exception {
Thread.sleep(100);
assertThat(tweet.getContent()).isEqualTo("New tweet");
assertThat(tweet.getOriginalAuthorId()).isEqualTo(originalAuthorId);
assertThat(tweet.getIsARetweet()).isTrue();
}