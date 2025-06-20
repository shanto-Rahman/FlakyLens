@Test(expected=RuntimeException.class) public void testDeleteIdsThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.deleteIds(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.deleteIds(null);
  verify(dao);
}
