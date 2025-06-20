@Test public void createFromUrl() throws Exception {
JDBCXADataSource dataSource=(JDBCXADataSource)wrapper.getXaDataSource();//IT
assertNotNull(dataSource);
assertThat(dataSource.getUrl(),equalTo("jdbc:hsqldb:mem:test"));
assertThat(dataSource.getUser(),equalTo("un"));
}