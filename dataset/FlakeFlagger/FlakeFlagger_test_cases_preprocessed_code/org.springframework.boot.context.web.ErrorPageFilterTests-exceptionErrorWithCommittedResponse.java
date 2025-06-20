@Test public void exceptionErrorWithCommittedResponse() throws Exception {
assertThat(this.response.getForwardedUrl(),is(nullValue()));
}