@Test public void assertUpdateWithExecuteUpdate() throws SQLException {
  int result;
  try (Statement statement=getEncryptConnection().createStatement()){
    result=statement.executeUpdate(UPDATE_SQL);
  }
   assertThat(result,is(2));
  assertResultSet(2,1,"encryptValue","f");
}
