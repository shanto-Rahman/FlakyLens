@Test public void testCallBatchTasksNestedInTransaction() throws Exception {
  SpecialConnectionSource cs=new SpecialConnectionSource(new H2ConnectionSource());
  final Dao<Foo,Integer> dao=DaoManager.createDao(cs,Foo.class);
  TableUtils.createTable(cs,Foo.class);
  final Foo foo=new Foo();
  assertEquals(1,dao.create(foo));
  TransactionManager.callInTransaction(cs,new Callable<Void>(){
    @Override public Void call() throws Exception {
      dao.callBatchTasks(new Callable<Void>(){
        @Override public Void call() throws Exception {
          dao.delete(foo);
          return null;
        }
      }
);
      return null;
    }
  }
);
  assertNull(dao.queryForId(foo.id));
  assertNull(cs.getSpecialConnection(dao.getTableName()));
}
