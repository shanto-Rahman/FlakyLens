@Test public void testCounter(){
HELPER.assertCounter("aboveHeapOccupancyLowWaterMarkCounter",10L,source);//RW
HELPER.assertCounter("tunerDoNothingCounter",11L,source);//RW
}