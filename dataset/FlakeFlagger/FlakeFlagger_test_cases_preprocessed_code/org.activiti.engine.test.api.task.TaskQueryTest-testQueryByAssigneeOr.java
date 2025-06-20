public void testQueryByAssigneeOr(){
assertEquals(1,query.count());
assertEquals(1,query.list().size());
assertNotNull(query.singleResult());
assertEquals(0,query.count());
assertEquals(0,query.list().size());
assertNull(query.singleResult());
}