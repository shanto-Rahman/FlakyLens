@Test(expected=RuntimeException.class) public void testUpdateRawThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.updateRaw(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.updateRaw(null);
  verify(dao);
}
