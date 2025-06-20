@Test public void statusErrorWithCommittedResponse() throws Exception {
assertThat(((HttpServletResponseWrapper)this.chain.getResponse()).getStatus(),equalTo(400));
assertTrue(this.response.isCommitted());
assertThat(this.response.getForwardedUrl(),is(nullValue()));
}