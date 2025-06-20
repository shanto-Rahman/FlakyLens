public void testQueryByCandidateGroupInOr(){
assertEquals(5,query.count());
assertEquals(5,query.list().size());
fail("expected exception");
assertEquals(11,query.count());
assertEquals(11,query.list().size());
assertEquals(6,query.count());
assertEquals(6,query.list().size());
assertEquals(0,query.count());
assertEquals(0,query.list().size());
assertEquals(5,query.count());
assertEquals(5,query.list().size());
assertEquals(5,query.count());
assertEquals(5,query.list().size());
}