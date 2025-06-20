@Test(expected=RuntimeException.class) public void testCreateObjectInstanceThrows() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.createObjectInstance()).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.createObjectInstance();
  verify(dao);
}
