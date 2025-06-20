@Test public void testDisableBetweenSplit() throws IOException {
assertEquals(0,cluster.getMaster().getClusterStatus().getRegionsInTransition().size());
}