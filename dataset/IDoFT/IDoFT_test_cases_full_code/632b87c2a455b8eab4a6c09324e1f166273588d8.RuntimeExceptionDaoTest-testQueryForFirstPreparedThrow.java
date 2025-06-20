@Test(expected=RuntimeException.class) public void testQueryForFirstPreparedThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryForFirst(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryForFirst(null);
  verify(dao);
}
