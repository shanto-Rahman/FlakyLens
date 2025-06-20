@Test public void assertInsertWithExecuteWithGeneratedKey() throws SQLException {
assertTrue(resultSet.next());
assertThat(resultSet.getInt(1),is(6));
assertFalse(resultSet.next());
}