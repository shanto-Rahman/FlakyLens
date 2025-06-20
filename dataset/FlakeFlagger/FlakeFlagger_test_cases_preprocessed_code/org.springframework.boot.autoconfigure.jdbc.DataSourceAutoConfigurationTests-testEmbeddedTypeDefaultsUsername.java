@Test public void testEmbeddedTypeDefaultsUsername() throws Exception {
assertNotNull(bean);
assertEquals("org.hsqldb.jdbcDriver",pool.getDriverClassName());
assertEquals("sa",pool.getUsername());
}