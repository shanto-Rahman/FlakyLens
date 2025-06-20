@Test(expected=RuntimeException.class) public void testQueryRawMapperThrows() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  String query="query";
  String[] args=new String[0];
  expect(dao.queryRaw(query,(DatabaseResultsMapper<?>)null,args)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryRaw(query,(DatabaseResultsMapper<?>)null,args);
  verify(dao);
}
