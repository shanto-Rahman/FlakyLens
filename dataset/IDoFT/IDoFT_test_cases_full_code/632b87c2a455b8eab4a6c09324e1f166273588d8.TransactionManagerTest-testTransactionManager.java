private void testTransactionManager(TransactionManager mgr,final Exception exception,final Dao<Foo,Integer> fooDao) throws Exception {
  final Foo foo1=new Foo();
  int val=13131511;
  foo1.val=val;
  assertEquals(1,fooDao.create(foo1));
  try {
    final int ret=13431231;
    int returned=mgr.callInTransaction(new Callable<Integer>(){
      @Override public Integer call() throws Exception {
        assertEquals(1,fooDao.delete(foo1));
        assertNull(fooDao.queryForId(foo1.id));
        if (exception != null) {
          throw exception;
        }
 else {
          return ret;
        }
      }
    }
);
    if (exception == null) {
      assertEquals(ret,returned);
    }
 else {
      fail("Should have thrown");
    }
  }
 catch (  SQLException e) {
    if (exception == null) {
      throw e;
    }
 else {
    }
  }
  if (exception == null) {
    assertNull(fooDao.queryForId(foo1.id));
  }
 else {
    Foo foo2=fooDao.queryForId(foo1.id);
    assertNotNull(foo2);
    assertEquals(val,foo2.val);
  }
}
