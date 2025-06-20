@Test public void expectFacebookAndTwitterConfigurationOnly() throws Exception {
assertNotNull(this.context.getBean(Facebook.class));
assertNotNull(this.context.getBean(Twitter.class));
}