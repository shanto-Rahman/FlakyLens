@Test public void testComboIndex() throws Exception {
  final ConnectionSource connectionSource=createMock(ConnectionSource.class);
  expect(connectionSource.getDatabaseType()).andReturn(databaseType).anyTimes();
  DatabaseConnection conn=createMock(DatabaseConnection.class);
  expect(connectionSource.getReadWriteConnection("comboindex")).andReturn(conn);
  final CompiledStatement stmt=createMock(CompiledStatement.class);
  expect(conn.compileStatement(isA(String.class),isA(StatementType.class),isA(FieldType[].class),anyInt(),anyBoolean())).andAnswer(new IAnswer<CompiledStatement>(){
    private int stmtC=0;
    @Override public CompiledStatement answer(){
      Object[] args=EasyMock.getCurrentArguments();
      assertNotNull(args);
      assertEquals("was expecting a call with 5 args",5,args.length);
      if (stmtC == 0) {
        assertEquals("CREATE TABLE `comboindex` (`stuff` VARCHAR(255) , `junk` BIGINT ) ",args[0]);
      }
 else       if (stmtC == 1) {
        assertEquals("CREATE INDEX `" + ComboIndex.INDEX_NAME + "` ON `comboindex` ( `stuff`, `junk` )",args[0]);
      }
 else       if (stmtC == 2) {
        assertEquals("DROP INDEX `" + ComboIndex.INDEX_NAME + "`",args[0]);
      }
 else       if (stmtC == 3) {
        assertEquals("DROP TABLE `comboindex` ",args[0]);
      }
 else {
        fail("Should only be called 4 times");
      }
      stmtC++;
      assertEquals(StatementType.EXECUTE,args[1]);
      assertEquals(0,((FieldType[])args[2]).length);
      return stmt;
    }
  }
).anyTimes();
  expect(stmt.runExecute()).andReturn(0).anyTimes();
  connectionSource.releaseConnection(conn);
  expect(connectionSource.getReadWriteConnection("comboindex")).andReturn(conn);
  connectionSource.releaseConnection(conn);
  expectLastCall().anyTimes();
  stmt.close();
  expectLastCall().anyTimes();
  replay(connectionSource,conn,stmt);
  TableUtils.createTable(connectionSource,ComboIndex.class);
  TableUtils.dropTable(connectionSource,ComboIndex.class,false);
  verify(connectionSource,conn,stmt);
}
