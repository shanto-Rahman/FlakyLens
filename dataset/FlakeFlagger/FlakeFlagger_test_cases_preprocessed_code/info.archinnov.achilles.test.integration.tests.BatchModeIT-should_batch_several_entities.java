@Test public void should_batch_several_entities() throws Exception {
assertThat(foundBean).isNull();
assertThat(foundTweet1).isNull();
assertThat(foundTweet2).isNull();
assertThat(foundUser).isNull();
assertThat(foundBean.getName()).isEqualTo("name");
assertThat(foundTweet1.getContent()).isEqualTo("tweet1");
assertThat(foundTweet2.getContent()).isEqualTo("tweet2");
assertThat(foundUser.getFirstname()).isEqualTo("fn");
assertThat(foundUser.getLastname()).isEqualTo("ln");
}