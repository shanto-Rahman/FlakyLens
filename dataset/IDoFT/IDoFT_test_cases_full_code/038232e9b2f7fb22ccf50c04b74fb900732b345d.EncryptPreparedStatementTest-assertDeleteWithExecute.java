@Test public void assertDeleteWithExecute() throws SQLException {
  try (PreparedStatement statement=getEncryptConnection().prepareStatement(DELETE_SQL)){
    statement.setObject(1,'a');
    statement.setObject(2,1);
    statement.execute();
  }
   assertResultSet(1,5,"encryptValue","assistedEncryptValue");
}
