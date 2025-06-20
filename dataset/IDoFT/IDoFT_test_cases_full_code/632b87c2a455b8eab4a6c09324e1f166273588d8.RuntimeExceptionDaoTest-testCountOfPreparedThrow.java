@Test(expected=RuntimeException.class) public void testCountOfPreparedThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  @SuppressWarnings("unchecked") PreparedQuery<Foo> prepared=(PreparedQuery<Foo>)createMock(PreparedQuery.class);
  expect(dao.countOf(prepared)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.countOf(prepared);
  verify(dao);
}
