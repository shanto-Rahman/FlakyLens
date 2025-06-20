@Test(expected=RuntimeException.class) public void testRefreshThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.refresh(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.refresh(null);
  verify(dao);
}
