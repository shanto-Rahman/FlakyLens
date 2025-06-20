@Test public void assertGetDataSource() throws JobEventListenerConfigurationException {
assertThat((BasicDataSource)(new JobEventRdbConfiguration(dataSource).getDataSource()),is(dataSource));
}