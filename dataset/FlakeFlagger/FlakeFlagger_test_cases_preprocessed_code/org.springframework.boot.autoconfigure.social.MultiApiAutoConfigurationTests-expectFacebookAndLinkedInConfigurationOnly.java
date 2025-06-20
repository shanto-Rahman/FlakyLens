@Test public void expectFacebookAndLinkedInConfigurationOnly() throws Exception {
assertNotNull(this.context.getBean(Facebook.class));
assertNotNull(this.context.getBean(LinkedIn.class));
}