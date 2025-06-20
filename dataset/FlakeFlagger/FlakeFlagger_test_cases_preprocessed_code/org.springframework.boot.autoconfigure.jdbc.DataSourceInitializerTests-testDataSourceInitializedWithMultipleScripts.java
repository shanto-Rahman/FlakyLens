@Test public void testDataSourceInitializedWithMultipleScripts() throws Exception {
assertTrue(dataSource instanceof org.apache.tomcat.jdbc.pool.DataSource);
assertNotNull(dataSource);
assertEquals(new Integer(1),template.queryForObject("SELECT COUNT(*) from FOO",Integer.class));
assertEquals(new Integer(0),template.queryForObject("SELECT COUNT(*) from SPAM",Integer.class));
}