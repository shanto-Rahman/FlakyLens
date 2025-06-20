/** 
 * Run a bunch of threads against a single TimeRangeTracker and ensure we arrive at right range.  The data chosen is going to ensure that there are lots collisions, i.e, some other threads may already update the value while one tries to update min/max value.
 */
@Test public void testConcurrentIncludeTimestampCorrectness(){
if (testData[i].getMin() < min) {//IT
min=testData[i].getMin();//IT
}
if (testData[i].getMax() > max) {//IT
max=testData[i].getMax();//IT
}
t[i].start();
thread.join();
assertTrue(min == trt.getMin());
assertTrue(max == trt.getMax());
}