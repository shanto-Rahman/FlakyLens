public void testQueryByUnassignedOr(){
assertEquals(11,query.count());
assertEquals(11,query.list().size());
}