@Test public void should_reinit_batch_context_after_exception() throws Exception {
assertThat(batchEm.find(Tweet.class,tweet.getId())).isNull();
assertThat(foundUser.getFirstname()).isEqualTo("firstname");
assertThat(foundUser.getLastname()).isEqualTo("lastname");
assertThat(foundTweet.getContent()).isEqualTo("simple_tweet");
assertThat(foundTweet.getCreator().getId()).isEqualTo(foundUser.getId());
assertThat(foundTweet.getCreator().getFirstname()).isEqualTo("firstname");
assertThat(foundTweet.getCreator().getLastname()).isEqualTo("lastname");
}