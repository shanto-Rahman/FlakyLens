public void testQueryByKeyLike(){
assertEquals("two_",query.singleResult().getKey());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
}