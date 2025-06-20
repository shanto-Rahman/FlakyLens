@Test(expected=RuntimeException.class) public void testGetSelectStarRowMapperThrow() throws Exception {
  @SuppressWarnings("unchecked") Dao<Foo,String> dao=(Dao<Foo,String>)createMock(Dao.class);
  RuntimeExceptionDao<Foo,String> rtDao=new RuntimeExceptionDao<Foo,String>(dao);
  expect(dao.getSelectStarRowMapper()).andThrow(new SQLException("Testing catch"));
  replay(dao);
  rtDao.getSelectStarRowMapper();
  verify(dao);
}
