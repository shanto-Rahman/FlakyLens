@Test(expected=RuntimeException.class) public void testUpdateIdThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.updateId(null,null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.updateId(null,null);
  verify(dao);
}
