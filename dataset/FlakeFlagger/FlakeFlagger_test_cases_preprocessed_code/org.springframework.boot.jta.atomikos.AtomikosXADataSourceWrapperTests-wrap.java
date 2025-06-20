@Test public void wrap() throws Exception {
assertThat(wrapped,instanceOf(AtomikosDataSourceBean.class));
assertThat(((AtomikosDataSourceBean)wrapped).getXaDataSource(),sameInstance(dataSource));
}