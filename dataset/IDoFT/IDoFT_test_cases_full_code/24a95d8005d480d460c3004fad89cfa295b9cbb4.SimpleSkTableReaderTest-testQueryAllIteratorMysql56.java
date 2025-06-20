@Test public void testQueryAllIteratorMysql56(){
  assertTestOf(this).withMysql56().withSql(sql).checkQueryAllIterator(testQueryBySk(allRowsPk(),true));
  assertTestOf(this).withMysql56().withSql(sql).checkQueryAllIteratorDesc(testQueryBySk(allRowsPk(),false));
}
