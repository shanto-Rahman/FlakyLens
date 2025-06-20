@Test(expected=RuntimeException.class) public void testSetObjectCacheThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  dao.setObjectCache(false);
  expectLastCall().andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.setObjectCache(false);
  verify(dao);
}
