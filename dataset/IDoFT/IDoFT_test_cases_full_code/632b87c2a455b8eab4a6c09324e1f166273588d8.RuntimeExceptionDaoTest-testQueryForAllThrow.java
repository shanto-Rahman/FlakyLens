@Test(expected=RuntimeException.class) public void testQueryForAllThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryForAll()).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryForAll();
  verify(dao);
}
