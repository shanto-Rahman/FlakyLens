@Test(expected=RuntimeException.class) public void testSetObjectCacheCacheThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  dao.setObjectCache(null);
  expectLastCall().andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.setObjectCache(null);
  verify(dao);
}
