@Test public void testFilterDoesNotAffectHosts() throws Throwable {
assertEquals(3,initialHostLinks.size());
assertFalse(filter.isActive());
assertEquals(3,selected.size());
}