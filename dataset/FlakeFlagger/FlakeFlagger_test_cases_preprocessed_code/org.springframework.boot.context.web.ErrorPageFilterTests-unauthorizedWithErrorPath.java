@Test public void unauthorizedWithErrorPath() throws Exception {
assertThat(this.chain.getRequest(),equalTo((ServletRequest)this.request));
assertThat(wrapper.getResponse(),equalTo((ServletResponse)this.response));
assertTrue(this.response.isCommitted());
assertThat(wrapper.getStatus(),equalTo(401));
assertThat(this.response.getStatus(),equalTo(401));
assertThat(this.response.getForwardedUrl(),equalTo("/error"));
}