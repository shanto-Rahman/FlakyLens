@Test(expected=RuntimeException.class) public void testQueryRawDateTypesThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryRaw(null,(DataType[])null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryRaw(null,(DataType[])null);
  verify(dao);
}
