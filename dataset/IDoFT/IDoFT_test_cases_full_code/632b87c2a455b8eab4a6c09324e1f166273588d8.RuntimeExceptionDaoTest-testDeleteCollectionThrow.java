@Test(expected=RuntimeException.class) public void testDeleteCollectionThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.delete((Collection<Foo>)null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.delete((Collection<Foo>)null);
  verify(dao);
}
