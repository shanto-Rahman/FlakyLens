@Test public void assertDeleteWithExecute() throws SQLException {
  try (Statement statement=getEncryptConnection().createStatement()){
    statement.execute(DELETE_SQL);
  }
   assertResultSet(1,5,"encryptValue","b");
}
