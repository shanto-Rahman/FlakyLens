@Test(expected=RuntimeException.class) public void testUpdateThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.update((Foo)null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.update((Foo)null);
  verify(dao);
}
