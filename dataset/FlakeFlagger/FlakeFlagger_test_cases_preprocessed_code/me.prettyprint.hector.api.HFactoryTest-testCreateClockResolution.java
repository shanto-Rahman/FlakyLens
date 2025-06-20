@Test public void testCreateClockResolution() throws Exception {
fail();
assertTrue(HFactory.createClockResolution(ClockResolution.SECONDS) instanceof SecondsClockResolution);
assertTrue(HFactory.createClockResolution(ClockResolution.MILLISECONDS) instanceof MillisecondsClockResolution);
assertTrue(HFactory.createClockResolution(ClockResolution.MICROSECONDS) instanceof MicrosecondsClockResolution);
assertTrue(HFactory.createClockResolution(ClockResolution.MICROSECONDS_SYNC) instanceof MicrosecondsSyncClockResolution);
}