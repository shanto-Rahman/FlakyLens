@Test public void diskSpaceIsUp() throws Exception {
assertEquals(Status.UP,health.getStatus());
assertEquals(THRESHOLD_BYTES,health.getDetails().get("threshold"));
assertEquals(THRESHOLD_BYTES + 10,health.getDetails().get("free"));
}