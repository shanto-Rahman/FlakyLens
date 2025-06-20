@Test(expected=RuntimeException.class) public void testIdExistsThrows() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  String id="eopwjfpwejf";
  expect(dao.idExists(id)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.idExists(id);
  verify(dao);
}
