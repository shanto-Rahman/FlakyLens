@Test public void assertInsertWithExecute() throws SQLException {
  try (PreparedStatement statement=getEncryptConnection().prepareStatement(INSERT_SQL)){
    statement.setObject(1,2);
    statement.setObject(2,'b');
    statement.execute();
  }
   assertResultSet(3,2,"encryptValue","assistedEncryptValue");
}
