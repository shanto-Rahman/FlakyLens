@Test public void responseIsNotCommitedWhenRequestIsAsync() throws Exception {
assertThat(this.chain.getRequest(),equalTo((ServletRequest)this.request));
assertThat(((HttpServletResponseWrapper)this.chain.getResponse()).getResponse(),equalTo((ServletResponse)this.response));
assertFalse(this.response.isCommitted());
}