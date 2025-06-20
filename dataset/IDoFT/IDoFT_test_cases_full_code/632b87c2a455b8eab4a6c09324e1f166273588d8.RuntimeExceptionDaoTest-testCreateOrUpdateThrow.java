@Test(expected=RuntimeException.class) public void testCreateOrUpdateThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.createOrUpdate(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.createOrUpdate(null);
  verify(dao);
}
