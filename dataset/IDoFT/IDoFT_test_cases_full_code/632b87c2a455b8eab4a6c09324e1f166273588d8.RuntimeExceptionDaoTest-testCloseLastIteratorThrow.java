@Test(expected=RuntimeException.class) public void testCloseLastIteratorThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  dao.closeLastIterator();
  expectLastCall().andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.closeLastIterator();
  verify(dao);
}
