@Test(expected=SQLException.class) public void testQueryRawColumnsNotQuery() throws Exception {
  Dao<SchemaFoo,String> dao=createDao(SchemaFoo.class,true);
  QueryBuilder<SchemaFoo,String> qb=dao.queryBuilder();
  qb.selectRaw("COUNT(*)");
  dao.query(qb.prepare());
}
