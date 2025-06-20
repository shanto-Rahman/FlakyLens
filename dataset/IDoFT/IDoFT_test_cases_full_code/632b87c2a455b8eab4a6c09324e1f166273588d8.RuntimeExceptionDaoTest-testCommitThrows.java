@Test(expected=RuntimeException.class) public void testCommitThrows() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  dao.commit(null);
  expectLastCall().andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.commit(null);
  verify(dao);
}
