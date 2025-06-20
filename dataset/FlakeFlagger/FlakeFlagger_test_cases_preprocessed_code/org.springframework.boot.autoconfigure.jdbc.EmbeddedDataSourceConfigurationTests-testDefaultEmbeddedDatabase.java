@Test public void testDefaultEmbeddedDatabase() throws Exception {
assertNotNull(this.context.getBean(DataSource.class));
}