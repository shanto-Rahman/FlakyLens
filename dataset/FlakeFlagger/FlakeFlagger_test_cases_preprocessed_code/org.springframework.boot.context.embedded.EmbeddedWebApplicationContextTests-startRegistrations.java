@Test public void startRegistrations() throws Exception {
assertThat(this.context.getServletContext(),equalTo(escf.getServletContext()));
assertThat(this.context.getBeanFactory().getRegisteredScope(WebApplicationContext.SCOPE_SESSION),instanceOf(SessionScope.class));
assertThat(this.context.containsBean(WebApplicationContext.SERVLET_CONTEXT_BEAN_NAME),equalTo(true));
}