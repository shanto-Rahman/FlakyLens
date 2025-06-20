@Test public void testMissingCreate() throws Exception {
  Dao<LocalFoo,Integer> fooDao=createDao(LocalFoo.class,false);
  try {
    fooDao.queryForAll();
    fail("Should have thrown");
  }
 catch (  SQLException e) {
  }
}
