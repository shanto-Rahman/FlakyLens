@Test public void assertUpdateWithExecuteUpdate() throws SQLException {
  int result;
  try (PreparedStatement statement=getEncryptConnection().prepareStatement(UPDATE_SQL)){
    statement.setObject(1,'f');
    statement.setObject(2,'a');
    result=statement.executeUpdate();
  }
   assertThat(result,is(2));
  assertResultSet(2,1,"encryptValue","assistedEncryptValue");
}
