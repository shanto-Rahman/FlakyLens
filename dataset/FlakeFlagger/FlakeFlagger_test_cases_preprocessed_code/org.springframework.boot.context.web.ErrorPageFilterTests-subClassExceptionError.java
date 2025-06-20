@Test public void subClassExceptionError() throws Exception {
assertThat(((HttpServletResponseWrapper)this.chain.getResponse()).getStatus(),equalTo(500));
assertThat(this.request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE),equalTo((Object)500));
assertThat(this.request.getAttribute(RequestDispatcher.ERROR_MESSAGE),equalTo((Object)"BAD"));
assertThat(this.request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE),equalTo((Object)IllegalStateException.class.getName()));
assertTrue(this.response.isCommitted());
}