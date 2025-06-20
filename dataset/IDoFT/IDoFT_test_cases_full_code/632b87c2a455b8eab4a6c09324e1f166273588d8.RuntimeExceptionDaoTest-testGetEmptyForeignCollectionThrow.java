@Test(expected=RuntimeException.class) public void testGetEmptyForeignCollectionThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.getEmptyForeignCollection(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.getEmptyForeignCollection(null);
  verify(dao);
}
