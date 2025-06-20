@Test(expected=RuntimeException.class) public void testExtractIdThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.extractId(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.extractId(null);
  verify(dao);
}
