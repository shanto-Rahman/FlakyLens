@Test public void propagateValueResolverToChildAndExtended() throws IOException {
assertEquals("User A-role, User B-role, ",template.apply(context));
}