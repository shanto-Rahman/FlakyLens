@Test public void createFromClass() throws Exception {
JDBCXADataSource dataSource=(JDBCXADataSource)wrapper.getXaDataSource();//IT
assertNotNull(dataSource);
assertThat(dataSource.getDatabaseName(),equalTo("test"));
}