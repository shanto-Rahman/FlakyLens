public void testQueryByActivityId(){
assertEquals(4,query.list().size());
assertEquals(4,query.count());
assertNull(query.singleResult());
fail();
}