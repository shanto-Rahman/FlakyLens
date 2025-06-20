@Test(expected=RuntimeException.class) public void testIsAutoCommitThrows() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.isAutoCommit(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.isAutoCommit(null);
  verify(dao);
}
