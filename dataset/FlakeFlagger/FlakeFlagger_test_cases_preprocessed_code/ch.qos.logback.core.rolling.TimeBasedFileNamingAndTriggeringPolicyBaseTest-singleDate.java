@Test public void singleDate(){
timeBasedFNATP.setCurrentTime(startTime + MILLIS_IN_MINUTE);//RW
assertEquals("foo-2011-12T59.log",elapsedPeriodsFileName);
}