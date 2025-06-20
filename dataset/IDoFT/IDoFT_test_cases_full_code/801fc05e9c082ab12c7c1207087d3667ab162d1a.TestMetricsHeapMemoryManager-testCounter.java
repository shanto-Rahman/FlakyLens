@Test public void testCounter(){
  for (int i=0; i < 10; i++) {
    hmm.increaseAboveHeapOccupancyLowWatermarkCounter();
  }
  for (int i=0; i < 11; i++) {
    hmm.increaseTunerDoNothingCounter();
  }
  HELPER.assertCounter("aboveHeapOccupancyLowWaterMarkCounter",10L,source);
  HELPER.assertCounter("tunerDoNothingCounter",11L,source);
}
