@Test public void wrap() throws Exception {
assertThat(wrapped,instanceOf(PoolingDataSourceBean.class));
assertThat(((PoolingDataSourceBean)wrapped).getDataSource(),sameInstance(dataSource));
}