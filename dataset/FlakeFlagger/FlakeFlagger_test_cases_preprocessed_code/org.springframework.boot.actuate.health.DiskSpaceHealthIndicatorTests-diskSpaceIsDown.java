@Test public void diskSpaceIsDown() throws Exception {
assertEquals(Status.DOWN,health.getStatus());
assertEquals(THRESHOLD_BYTES,health.getDetails().get("threshold"));
assertEquals(THRESHOLD_BYTES - 10,health.getDetails().get("free"));
}