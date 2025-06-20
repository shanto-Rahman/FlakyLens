@Test(expected=RuntimeException.class) public void testQueryForEqThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryForEq(null,null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryForEq(null,null);
  verify(dao);
}
