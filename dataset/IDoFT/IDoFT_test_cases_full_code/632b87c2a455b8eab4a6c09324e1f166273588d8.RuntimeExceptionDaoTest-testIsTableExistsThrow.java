@Test(expected=RuntimeException.class) public void testIsTableExistsThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.isTableExists()).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.isTableExists();
  verify(dao);
}
