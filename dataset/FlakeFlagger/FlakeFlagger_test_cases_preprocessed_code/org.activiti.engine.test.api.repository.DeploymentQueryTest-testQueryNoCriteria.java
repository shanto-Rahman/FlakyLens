public void testQueryNoCriteria(){
assertEquals(2,query.list().size());
assertEquals(2,query.count());
fail();
}