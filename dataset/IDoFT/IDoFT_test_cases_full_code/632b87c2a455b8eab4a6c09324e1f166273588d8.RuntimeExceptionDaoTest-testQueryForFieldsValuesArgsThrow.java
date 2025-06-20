@Test(expected=RuntimeException.class) public void testQueryForFieldsValuesArgsThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryForFieldValuesArgs(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryForFieldValuesArgs(null);
  verify(dao);
}
