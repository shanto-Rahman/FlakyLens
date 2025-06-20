@Test public void testQueryAllIteratorMysql80(){
  assertTestOf(this).withMysql80().withSql(sql).checkQueryAllIterator(testQueryBySk(allRowsPk(),true));
  assertTestOf(this).withMysql80().withSql(sql).checkQueryAllIteratorDesc(testQueryBySk(allRowsPk(),false));
}
