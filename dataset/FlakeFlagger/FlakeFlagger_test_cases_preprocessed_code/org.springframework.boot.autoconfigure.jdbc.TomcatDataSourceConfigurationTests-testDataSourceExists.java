@Test public void testDataSourceExists() throws Exception {
assertNotNull(this.context.getBean(DataSource.class));
assertNotNull(this.context.getBean(org.apache.tomcat.jdbc.pool.DataSource.class));
}