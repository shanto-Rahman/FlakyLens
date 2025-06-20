public void testQueryByDescriptionLike(){
assertNotNull(query.singleResult());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
}