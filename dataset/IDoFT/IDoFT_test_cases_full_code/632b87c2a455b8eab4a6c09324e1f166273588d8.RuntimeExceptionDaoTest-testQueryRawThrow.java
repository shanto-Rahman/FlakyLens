@Test(expected=RuntimeException.class) public void testQueryRawThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryRaw(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryRaw(null);
  verify(dao);
}
