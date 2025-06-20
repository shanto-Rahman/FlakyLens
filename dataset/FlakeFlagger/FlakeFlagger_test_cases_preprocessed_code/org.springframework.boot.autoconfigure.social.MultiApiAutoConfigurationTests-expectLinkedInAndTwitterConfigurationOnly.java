@Test public void expectLinkedInAndTwitterConfigurationOnly() throws Exception {
assertNotNull(this.context.getBean(LinkedIn.class));
assertNotNull(this.context.getBean(Twitter.class));
}