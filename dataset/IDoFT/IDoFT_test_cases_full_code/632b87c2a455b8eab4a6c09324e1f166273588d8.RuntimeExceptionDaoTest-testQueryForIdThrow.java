@Test(expected=RuntimeException.class) public void testQueryForIdThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryForId(isA(String.class))).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryForId("wow");
  verify(dao);
}
