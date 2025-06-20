@Test public void testQueryAllIteratorMysql57(){
  assertTestOf(this).withMysql57().withSql(sql).checkQueryAllIterator(testQueryBySk(allRowsPk(),true));
  assertTestOf(this).withMysql57().withSql(sql).checkQueryAllIteratorDesc(testQueryBySk(allRowsPk(),false));
}
