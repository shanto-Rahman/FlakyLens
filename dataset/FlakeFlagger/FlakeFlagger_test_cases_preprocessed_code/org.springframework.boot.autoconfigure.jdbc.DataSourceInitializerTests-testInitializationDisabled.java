@Test public void testInitializationDisabled() throws Exception {
assertTrue(dataSource instanceof org.apache.tomcat.jdbc.pool.DataSource);
assertNotNull(dataSource);
fail("Query should have failed as BAR table does not exist");
assertEquals(expectedCode,sqlException.getErrorCode());
}