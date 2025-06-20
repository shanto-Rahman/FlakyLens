public void testQueryNoCriteria(){
assertEquals(12,query.count());
assertEquals(12,query.list().size());
fail("expected exception");
}