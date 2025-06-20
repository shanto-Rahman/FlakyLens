@Test(expected=RuntimeException.class) public void testUpdatePreparedThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.update((PreparedUpdate<Foo>)null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.update((PreparedUpdate<Foo>)null);
  verify(dao);
}
