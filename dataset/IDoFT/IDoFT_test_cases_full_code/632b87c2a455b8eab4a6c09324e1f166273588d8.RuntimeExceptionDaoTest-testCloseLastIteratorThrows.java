@Test(expected=RuntimeException.class) public void testCloseLastIteratorThrows() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  dao.closeLastIterator();
  expectLastCall().andThrow(new IOException("Testing catch"));
  replay(dao);
  rtDao.closeLastIterator();
  verify(dao);
}
