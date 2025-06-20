public void testQueryByCandidateUser(){
assertEquals(11,query.count());
assertEquals(11,query.list().size());
fail("expected exception");
assertEquals(3,query.count());
assertEquals(3,query.list().size());
fail("expected exception");
}