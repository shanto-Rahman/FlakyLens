@Test public void globalError() throws Exception {
assertThat(((HttpServletResponseWrapper)this.chain.getResponse()).getStatus(),equalTo(400));
assertThat(this.request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE),equalTo((Object)400));
assertThat(this.request.getAttribute(RequestDispatcher.ERROR_MESSAGE),equalTo((Object)"BAD"));
assertTrue(this.response.isCommitted());
assertThat(this.response.getForwardedUrl(),equalTo("/error"));
}