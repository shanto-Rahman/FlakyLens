@Test public void multiDate(){
timeBasedFNATP.setCurrentTime(startTime + MILLIS_IN_MINUTE);//RW
assertEquals("foo-2011-12/59.log",elapsedPeriodsFileName);
}