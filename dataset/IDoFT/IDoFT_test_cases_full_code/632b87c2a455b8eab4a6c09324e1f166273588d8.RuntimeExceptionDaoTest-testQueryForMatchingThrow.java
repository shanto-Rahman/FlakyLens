@Test(expected=RuntimeException.class) public void testQueryForMatchingThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryForMatching(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryForMatching(null);
  verify(dao);
}
