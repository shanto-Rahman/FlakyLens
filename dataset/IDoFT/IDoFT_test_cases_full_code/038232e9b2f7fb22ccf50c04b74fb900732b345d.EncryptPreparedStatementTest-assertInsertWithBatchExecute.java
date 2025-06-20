@Test public void assertInsertWithBatchExecute() throws SQLException {
  try (PreparedStatement statement=getEncryptConnection().prepareStatement(INSERT_SQL)){
    statement.setObject(1,3);
    statement.setObject(2,'c');
    statement.addBatch();
    statement.setObject(1,4);
    statement.setObject(2,'d');
    statement.addBatch();
    statement.executeBatch();
  }
   assertResultSet(4,3,"encryptValue","assistedEncryptValue");
}
