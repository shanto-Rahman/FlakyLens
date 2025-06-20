public void testQueryByNameLike(){
assertEquals("one%",query.singleResult().getName());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
assertEquals("two_",query.singleResult().getName());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
}