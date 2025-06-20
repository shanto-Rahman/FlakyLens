@Test public void responseIsCommitedWhenRequestIsAsyncAndStatusIs400Plus() throws Exception {
assertThat(this.chain.getRequest(),equalTo((ServletRequest)this.request));
assertThat(((HttpServletResponseWrapper)this.chain.getResponse()).getResponse(),equalTo((ServletResponse)this.response));
assertTrue(this.response.isCommitted());
}