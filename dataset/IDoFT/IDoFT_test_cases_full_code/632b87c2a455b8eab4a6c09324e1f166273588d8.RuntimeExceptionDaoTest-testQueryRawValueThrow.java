@Test(expected=RuntimeException.class) public void testQueryRawValueThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryRawValue(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryRawValue(null);
  verify(dao);
}
