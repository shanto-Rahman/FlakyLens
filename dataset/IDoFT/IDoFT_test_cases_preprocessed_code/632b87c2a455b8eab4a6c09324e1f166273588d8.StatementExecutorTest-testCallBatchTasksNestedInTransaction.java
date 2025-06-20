@Test public void testCallBatchTasksNestedInTransaction() throws Exception {
assertEquals(1,dao.create(foo));
assertNull(dao.queryForId(foo.id));
assertNull(cs.getSpecialConnection(dao.getTableName()));
}