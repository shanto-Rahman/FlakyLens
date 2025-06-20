@Test public void should_merge() throws Exception {
assertThat(found.getContent()).isEqualTo("this is a new tweet2");
assertThat(found.getOriginalAuthorId()).isEqualTo(originalAuthorId);
assertThat(found.getIsARetweet()).isTrue();
}