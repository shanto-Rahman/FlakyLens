@Test(expected=RuntimeException.class) public void testSetAutoCommitThrows() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  dao.setAutoCommit(null,true);
  expectLastCall().andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.setAutoCommit(null,true);
  verify(dao);
}
