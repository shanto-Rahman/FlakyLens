@Test public void testFilterBasedOnMaxLoadedHost() throws Throwable {
assertEquals(1,selected.size());
assertNotNull(selected.get(secondHost));
assertEquals(1,selected.size());
assertNotNull(selected.get(thirdHost));
}