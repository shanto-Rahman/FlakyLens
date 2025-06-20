@Test(expected=RuntimeException.class) public void testAssignEmptyForeignCollectionThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  dao.assignEmptyForeignCollection(null,null);
  expectLastCall().andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.assignEmptyForeignCollection(null,null);
  verify(dao);
}
