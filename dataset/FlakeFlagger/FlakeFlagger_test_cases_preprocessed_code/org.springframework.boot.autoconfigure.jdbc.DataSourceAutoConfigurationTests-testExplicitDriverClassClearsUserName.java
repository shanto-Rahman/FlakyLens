@Test public void testExplicitDriverClassClearsUserName() throws Exception {
assertNotNull(bean);
assertEquals("org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfigurationTests$DatabaseDriver",pool.getDriverClassName());
assertNull(pool.getUsername());
}