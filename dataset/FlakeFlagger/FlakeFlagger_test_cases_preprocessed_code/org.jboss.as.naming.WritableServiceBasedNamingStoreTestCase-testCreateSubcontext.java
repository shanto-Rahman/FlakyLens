@Test public void testCreateSubcontext() throws Exception {
assertTrue(((NamingContext)store.createSubcontext(new CompositeName("test"))).getNamingStore() instanceof WritableServiceBasedNamingStore);
}