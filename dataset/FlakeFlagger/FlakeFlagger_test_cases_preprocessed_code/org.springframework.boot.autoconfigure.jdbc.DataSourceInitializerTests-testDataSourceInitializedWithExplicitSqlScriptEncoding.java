@Test public void testDataSourceInitializedWithExplicitSqlScriptEncoding() throws Exception {
assertTrue(dataSource instanceof org.apache.tomcat.jdbc.pool.DataSource);
assertNotNull(dataSource);
assertEquals(new Integer(2),template.queryForObject("SELECT COUNT(*) from BAR",Integer.class));
assertEquals("bar",template.queryForObject("SELECT name from BAR WHERE id=1",String.class));
assertEquals("ばー",template.queryForObject("SELECT name from BAR WHERE id=2",String.class));
}