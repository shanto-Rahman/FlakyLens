@Test public void connectionClosed() throws Exception {
given(dataSource.getConnection()).willReturn(connection);
assertNotNull(health.getDetails().get("database"));
}