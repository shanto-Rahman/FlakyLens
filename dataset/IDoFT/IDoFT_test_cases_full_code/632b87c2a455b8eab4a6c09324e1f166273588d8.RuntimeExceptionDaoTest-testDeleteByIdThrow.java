@Test(expected=RuntimeException.class) public void testDeleteByIdThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.deleteById(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.deleteById(null);
  verify(dao);
}
