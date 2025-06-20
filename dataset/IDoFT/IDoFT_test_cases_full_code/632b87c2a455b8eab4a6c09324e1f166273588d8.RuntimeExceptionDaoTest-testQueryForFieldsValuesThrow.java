@Test(expected=RuntimeException.class) public void testQueryForFieldsValuesThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.queryForFieldValues(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.queryForFieldValues(null);
  verify(dao);
}
