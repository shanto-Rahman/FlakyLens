@Test public void expectFacebookConfigurationOnly() throws Exception {
assertNotNull(this.context.getBean(Facebook.class));
}