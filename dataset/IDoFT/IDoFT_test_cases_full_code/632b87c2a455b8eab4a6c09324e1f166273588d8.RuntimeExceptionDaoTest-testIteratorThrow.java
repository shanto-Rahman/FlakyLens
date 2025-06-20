@Test(expected=RuntimeException.class) public void testIteratorThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.iterator(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.iterator(null);
  verify(dao);
}
