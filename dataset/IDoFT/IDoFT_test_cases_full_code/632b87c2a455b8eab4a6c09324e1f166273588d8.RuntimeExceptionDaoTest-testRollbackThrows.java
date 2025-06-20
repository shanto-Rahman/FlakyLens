@Test(expected=RuntimeException.class) public void testRollbackThrows() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  dao.rollBack(null);
  expectLastCall().andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.rollBack(null);
  verify(dao);
}
