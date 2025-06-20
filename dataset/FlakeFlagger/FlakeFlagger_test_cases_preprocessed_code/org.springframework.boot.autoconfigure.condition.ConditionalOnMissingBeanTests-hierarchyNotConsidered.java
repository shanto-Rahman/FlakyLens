@Test public void hierarchyNotConsidered() throws Exception {
assertTrue(childContext.containsLocalBean("bar"));
}