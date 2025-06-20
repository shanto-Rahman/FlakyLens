@Test public void testHikariIsFallback() throws Exception {
assertEquals("jdbc:hsqldb:mem:testdb",pool.getJdbcUrl());
}