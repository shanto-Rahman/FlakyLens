@Test public void testFilterWithLocalNonNamedVolumes() throws Throwable {
assertTrue(filter.isActive());
assertEquals(3,selected.size());
}