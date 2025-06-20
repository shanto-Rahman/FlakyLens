/** 
 * Run a bunch of threads against a single TimeRangeTracker and ensure we arrive at right range.  The data chosen is going to ensure that there are lots collisions, i.e, some other threads may already update the value while one tries to update min/max value.
 */
@Test public void testConcurrentIncludeTimestampCorrectness(){
  RandomTestData[] testData=new RandomTestData[NUM_OF_THREADS];
  long min=Long.MAX_VALUE, max=0;
  for (int i=0; i < NUM_OF_THREADS; i++) {
    testData[i]=new RandomTestData();
    if (testData[i].getMin() < min) {
      min=testData[i].getMin();
    }
    if (testData[i].getMax() > max) {
      max=testData[i].getMax();
    }
  }
  TimeRangeTracker trt=TimeRangeTracker.create(TimeRangeTracker.Type.SYNC);
  Thread[] t=new Thread[NUM_OF_THREADS];
  for (int i=0; i < NUM_OF_THREADS; i++) {
    t[i]=new Thread(new TrtUpdateRunnable(trt,testData[i]));
    t[i].start();
  }
  for (  Thread thread : t) {
    try {
      thread.join();
    }
 catch (    InterruptedException e) {
      e.printStackTrace();
    }
  }
  assertTrue(min == trt.getMin());
  assertTrue(max == trt.getMax());
}
