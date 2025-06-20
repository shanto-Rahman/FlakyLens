@Test public void assertInsertWithExecute() throws SQLException {
  try (Statement statement=getEncryptConnection().createStatement()){
    statement.execute(INSERT_SQL);
  }
   assertResultSet(3,2,"encryptValue","b");
}
