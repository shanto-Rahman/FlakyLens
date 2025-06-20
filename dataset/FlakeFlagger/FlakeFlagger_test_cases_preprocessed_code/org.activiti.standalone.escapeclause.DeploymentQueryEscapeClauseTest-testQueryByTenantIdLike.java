public void testQueryByTenantIdLike(){
assertEquals("One%",query.singleResult().getTenantId());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
assertEquals("Two_",query.singleResult().getTenantId());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
}