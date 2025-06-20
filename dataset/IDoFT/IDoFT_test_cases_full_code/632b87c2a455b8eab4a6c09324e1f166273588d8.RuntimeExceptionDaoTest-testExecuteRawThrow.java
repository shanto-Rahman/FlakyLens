@Test(expected=RuntimeException.class) public void testExecuteRawThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.executeRaw(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.executeRaw(null);
  verify(dao);
}
