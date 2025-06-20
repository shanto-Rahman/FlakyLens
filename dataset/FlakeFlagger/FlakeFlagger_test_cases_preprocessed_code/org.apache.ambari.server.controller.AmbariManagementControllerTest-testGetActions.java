@SuppressWarnings("serial") @Test public void testGetActions() throws Exception {
assertFalse(responses.isEmpty());
assertEquals(1,responses.size());
assertEquals(Role.HDFS_SERVICE_CHECK.name(),response.getActionName());
}