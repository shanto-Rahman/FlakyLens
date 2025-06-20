@Test(expected=RuntimeException.class) public void testIteratorQueryFlags(){
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(rtDao.iterator(null,0)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.iterator(null,0);
  verify(dao);
}
