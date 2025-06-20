@Test public void testFilterHostsWhenLocalDriverIsNotReported() throws Throwable {
assertEquals(4,initialHostLinks.size());
assertEquals(4,selectedHosts.size());
assertTrue(selectedHosts.keySet().contains(hostLink));
}