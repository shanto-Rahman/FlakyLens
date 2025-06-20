@Test(expected=RuntimeException.class) public void testDeleteThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.delete((Foo)null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.delete((Foo)null);
  verify(dao);
}
