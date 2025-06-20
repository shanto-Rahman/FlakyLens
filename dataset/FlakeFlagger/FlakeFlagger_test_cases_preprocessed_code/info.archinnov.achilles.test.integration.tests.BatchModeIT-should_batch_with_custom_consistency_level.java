@Test public void should_batch_with_custom_consistency_level() throws Exception {
assertThat(foundTweet1.getContent()).isEqualTo(tweet1.getContent());
}