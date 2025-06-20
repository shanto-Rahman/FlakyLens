private void testTransactionManager(TransactionManager mgr,final Exception exception,final Dao<Foo,Integer> fooDao) throws Exception {
assertEquals(1,fooDao.create(foo1));
assertEquals(1,fooDao.delete(foo1));
assertNull(fooDao.queryForId(foo1.id));
if (exception != null) {
}
if (exception == null) {
assertEquals(ret,returned);
fail("Should have thrown");
}
if (exception == null) {
}
if (exception == null) {
assertNull(fooDao.queryForId(foo1.id));
assertNotNull(foo2);
assertEquals(val,foo2.val);
}
}