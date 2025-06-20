public void testQueryByPriority(){
assertEquals(2,query.list().size());
assertEquals(2,query.count());
fail();
assertNull(query.singleResult());
assertEquals(0,query.list().size());
assertEquals(0,query.count());
assertEquals(3,query.list().size());
assertEquals(5,query.list().size());
assertEquals(9,query.list().size());
assertEquals(6,query.list().size());
}