@Test public void testDataSourceInitialized() throws Exception {
assertTrue(dataSource instanceof org.apache.tomcat.jdbc.pool.DataSource);
assertNotNull(dataSource);
assertEquals(new Integer(1),template.queryForObject("SELECT COUNT(*) from BAR",Integer.class));
}