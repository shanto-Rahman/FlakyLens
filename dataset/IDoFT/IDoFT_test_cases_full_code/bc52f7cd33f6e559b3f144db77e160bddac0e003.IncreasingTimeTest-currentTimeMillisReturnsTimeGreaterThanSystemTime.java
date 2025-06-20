@Test public void currentTimeMillisReturnsTimeGreaterThanSystemTime(){
  for (int i=0; i < NUM_ITERATIONS; i++) {
    long systemTime=System.currentTimeMillis();
    long increasedTime=IncreasingTime.currentTimeMillis();
    assertTrue(increasedTime > systemTime);
  }
}
