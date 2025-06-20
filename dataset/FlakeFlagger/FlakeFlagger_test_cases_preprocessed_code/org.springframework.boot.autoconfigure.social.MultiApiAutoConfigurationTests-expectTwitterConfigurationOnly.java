@Test public void expectTwitterConfigurationOnly() throws Exception {
assertNotNull(this.context.getBean(Twitter.class));
}