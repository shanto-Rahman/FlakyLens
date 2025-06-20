@Test public void testNoRepositoryConfiguration() throws Exception {
assertNotNull(this.context.getBean(Client.class));
}