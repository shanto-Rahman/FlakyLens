@Test public void responseUncommittedWithoutErrorPage() throws Exception {
assertThat(this.chain.getRequest(),equalTo((ServletRequest)this.request));
assertThat(((HttpServletResponseWrapper)this.chain.getResponse()).getResponse(),equalTo((ServletResponse)this.response));
assertThat(((HttpServletResponseWrapper)this.chain.getResponse()).getStatus(),equalTo(400));
assertThat(this.response.getForwardedUrl(),is(nullValue()));
assertTrue(this.response.isCommitted());
}