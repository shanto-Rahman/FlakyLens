@Test(expected=RuntimeException.class) public void testStartThreadConnectionThrows() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.startThreadConnection()).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.startThreadConnection();
  verify(dao);
}
