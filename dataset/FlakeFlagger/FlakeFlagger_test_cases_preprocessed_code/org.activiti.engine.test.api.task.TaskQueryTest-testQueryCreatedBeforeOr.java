public void testQueryCreatedBeforeOr() throws Exception {
assertEquals(7,query.count());
assertEquals(7,query.list().size());
assertEquals(0,query.count());
assertEquals(0,query.list().size());
}