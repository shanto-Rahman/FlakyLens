@Test(expected=RuntimeException.class) public void testObjectsEqualThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.objectsEqual(null,null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.objectsEqual(null,null);
  verify(dao);
}
