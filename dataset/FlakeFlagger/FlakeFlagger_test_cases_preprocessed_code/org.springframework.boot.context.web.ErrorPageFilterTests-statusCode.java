@Test public void statusCode() throws Exception {
assertThat(((HttpServletResponse)response).getStatus(),equalTo(200));
assertThat(((HttpServletResponseWrapper)this.chain.getResponse()).getStatus(),equalTo(200));
}