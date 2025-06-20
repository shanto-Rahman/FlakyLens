@Test(expected=RuntimeException.class) public void testQueryRawRowMapperThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryRaw(null,(RawRowMapper<String>)null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryRaw(null,(RawRowMapper<String>)null);
  verify(dao);
}
