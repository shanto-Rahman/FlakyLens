@SuppressWarnings({"unchecked","rawtypes"}) @Test(expected=RuntimeException.class) public void testCreateCollectionThrow() throws Exception {
  Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.create((Collection)null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.create((Collection)null);
  verify(dao);
}
