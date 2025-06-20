@Test public void assertInsertWithExecuteWithGeneratedKey() throws SQLException {
  try (PreparedStatement statement=getEncryptConnection().prepareStatement(INSERT_GENERATED_KEY_SQL,Statement.RETURN_GENERATED_KEYS)){
    statement.execute();
    ResultSet resultSet=statement.getGeneratedKeys();
    assertTrue(resultSet.next());
    assertThat(resultSet.getInt(1),is(6));
    assertFalse(resultSet.next());
  }
   assertResultSet(3,2,"encryptValue","assistedEncryptValue");
}
