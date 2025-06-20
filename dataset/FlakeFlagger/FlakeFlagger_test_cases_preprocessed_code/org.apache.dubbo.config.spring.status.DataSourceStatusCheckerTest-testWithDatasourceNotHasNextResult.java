@Test public void testWithDatasourceNotHasNextResult() throws SQLException {
given(dataSource.getConnection()).willReturn(connection);
assertThat(status.getLevel(),is(Status.Level.ERROR));
}