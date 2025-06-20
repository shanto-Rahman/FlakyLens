public void testQueryCreatedAfterOr() throws Exception {
assertEquals(3,query.count());
assertEquals(3,query.list().size());
assertEquals(0,query.count());
assertEquals(0,query.list().size());
}