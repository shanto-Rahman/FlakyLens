@Test public void testWithDatasourceHasNextResult() throws SQLException {
given(dataSource.getConnection()).willReturn(connection);
assertThat(status.getLevel(),is(Status.Level.OK));
}