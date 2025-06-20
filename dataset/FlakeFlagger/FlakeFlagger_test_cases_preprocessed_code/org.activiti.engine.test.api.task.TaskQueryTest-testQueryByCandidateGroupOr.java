public void testQueryByCandidateGroupOr(){
assertEquals(3,query.count());
assertEquals(3,query.list().size());
fail("expected exception");
assertEquals(0,query.count());
assertEquals(0,query.list().size());
}