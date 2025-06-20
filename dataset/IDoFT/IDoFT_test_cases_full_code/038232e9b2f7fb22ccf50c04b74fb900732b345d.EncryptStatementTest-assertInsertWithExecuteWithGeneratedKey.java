@Test public void assertInsertWithExecuteWithGeneratedKey() throws SQLException {
  try (Statement statement=getEncryptConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY)){
    statement.execute(INSERT_GENERATED_KEY_SQL,Statement.RETURN_GENERATED_KEYS);
    ResultSet resultSet=statement.getGeneratedKeys();
    assertTrue(resultSet.next());
    assertThat(resultSet.getInt(1),is(6));
    assertFalse(resultSet.next());
  }
   assertResultSet(3,6,"encryptValue","b");
}
