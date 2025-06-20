@Test(expected=RuntimeException.class) public void testQueryThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.query(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.query(null);
  verify(dao);
}
