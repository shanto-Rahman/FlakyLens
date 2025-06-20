@Test public void testQueryRawFirst() throws Exception {
  Dao<Foo,Integer> dao=createDao(Foo.class,true);
  Foo foo=new Foo();
  foo.stringField="zipper";
  dao.create(foo);
  QueryBuilder<Foo,Integer> qb=dao.queryBuilder();
  assertEquals(1,qb.countOf());
  String[] result=qb.queryRawFirst();
  assertEquals(4,result.length);
  assertEquals(Integer.toString(foo.id),result[0]);
  assertEquals(foo.stringField,result[3]);
}
