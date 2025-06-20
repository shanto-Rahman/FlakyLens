@Test public void testMembershipJoinAndLeave() throws Exception {
assertTrue(stat.getEphemeralOwner() > 0);
assertNotNull(stat);
assertEquals(endpoint.toString(),endpoint0.toString());
assertNull(stat);
}