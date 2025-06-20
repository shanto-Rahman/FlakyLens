@Test(expected=RuntimeException.class) public void testCountOfThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.countOf()).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.countOf();
  verify(dao);
}
