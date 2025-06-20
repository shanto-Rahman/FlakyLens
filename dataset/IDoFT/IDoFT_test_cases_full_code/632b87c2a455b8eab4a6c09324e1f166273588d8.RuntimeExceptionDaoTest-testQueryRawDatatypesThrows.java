@Test(expected=RuntimeException.class) public void testQueryRawDatatypesThrows() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  String query="query";
  DataType[] datatypes=new DataType[0];
  String[] args=new String[0];
  expect(dao.queryRaw(query,datatypes,null,args)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryRaw(query,datatypes,null,args);
  verify(dao);
}
