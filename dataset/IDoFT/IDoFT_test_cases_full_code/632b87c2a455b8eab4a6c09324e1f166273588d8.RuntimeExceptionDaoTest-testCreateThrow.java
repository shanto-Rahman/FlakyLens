@Test(expected=RuntimeException.class) public void testCreateThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.create((Foo)null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.create((Foo)null);
  verify(dao);
}
