@Test(expected=RuntimeException.class) public void testExecuteRawNoArgsThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.executeRawNoArgs(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.executeRawNoArgs(null);
  verify(dao);
}
