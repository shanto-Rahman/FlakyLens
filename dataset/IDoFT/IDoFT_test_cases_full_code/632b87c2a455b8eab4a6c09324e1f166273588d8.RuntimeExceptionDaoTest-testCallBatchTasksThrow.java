@Test(expected=RuntimeException.class) public void testCallBatchTasksThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.callBatchTasks(null)).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.callBatchTasks(null);
  verify(dao);
}
