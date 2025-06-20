@Test(expected=RuntimeException.class) public void testQueryForSameIdThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryForSameId(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryForSameId(null);
  verify(dao);
}
