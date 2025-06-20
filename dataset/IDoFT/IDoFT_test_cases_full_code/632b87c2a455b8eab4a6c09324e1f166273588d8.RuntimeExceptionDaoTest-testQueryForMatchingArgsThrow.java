@Test(expected=RuntimeException.class) public void testQueryForMatchingArgsThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryForMatchingArgs(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryForMatchingArgs(null);
  verify(dao);
}
