public void testQueryByNameLike(){
assertEquals("One%",query.singleResult().getName());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
assertEquals("Two_",query.singleResult().getName());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
}