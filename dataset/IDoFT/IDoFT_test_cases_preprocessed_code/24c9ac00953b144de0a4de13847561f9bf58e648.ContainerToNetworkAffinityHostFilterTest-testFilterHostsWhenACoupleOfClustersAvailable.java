@Test public void testFilterHostsWhenACoupleOfClustersAvailable() throws Throwable {
assertTrue(filter.isActive());
if (kvStoreName == null) {
}
assertTrue("Selected hosts are not in the same cluster",kvStoreName.equals(selected.get(key).clusterStore));
}