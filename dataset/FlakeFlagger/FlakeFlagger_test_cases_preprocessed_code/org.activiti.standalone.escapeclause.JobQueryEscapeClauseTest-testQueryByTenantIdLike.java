public void testQueryByTenantIdLike(){
assertEquals("tenant%",query.singleResult().getTenantId());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
assertEquals("tenant_",query.singleResult().getTenantId());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
assertEquals("test",query.singleResult().getTenantId());
assertEquals(1,query.list().size());
assertEquals(1,query.count());
}