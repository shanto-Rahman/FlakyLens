@Test public void indicatesUp() throws Exception {
assertEquals(Status.UP,healthIndicator.health().getStatus());
}