/** 
 * Test merging of a large new window that covers multiple existing windows.
 */
@Test public void testMergeLargeWindowCoveringMultipleWindows() throws Exception {
  @SuppressWarnings("unchecked") ListState<Tuple2<TimeWindow,TimeWindow>> mockState=mock(ListState.class);
  MergingWindowSet<TimeWindow> windowSet=new MergingWindowSet<>(EventTimeSessionWindows.withGap(Time.milliseconds(3)),mockState);
  TestingMergeFunction mergeFunction=new TestingMergeFunction();
  mergeFunction.reset();
  assertEquals(new TimeWindow(1,3),windowSet.addWindow(new TimeWindow(1,3),mergeFunction));
  assertFalse(mergeFunction.hasMerged());
  assertEquals(new TimeWindow(1,3),windowSet.getStateWindow(new TimeWindow(1,3)));
  mergeFunction.reset();
  assertEquals(new TimeWindow(5,8),windowSet.addWindow(new TimeWindow(5,8),mergeFunction));
  assertFalse(mergeFunction.hasMerged());
  assertEquals(new TimeWindow(5,8),windowSet.getStateWindow(new TimeWindow(5,8)));
  mergeFunction.reset();
  assertEquals(new TimeWindow(10,13),windowSet.addWindow(new TimeWindow(10,13),mergeFunction));
  assertFalse(mergeFunction.hasMerged());
  assertEquals(new TimeWindow(10,13),windowSet.getStateWindow(new TimeWindow(10,13)));
  mergeFunction.reset();
  assertEquals(new TimeWindow(0,13),windowSet.addWindow(new TimeWindow(0,13),mergeFunction));
  assertTrue(mergeFunction.hasMerged());
  assertThat(mergeFunction.mergedStateWindows(),anyOf(containsInAnyOrder(new TimeWindow(0,3),new TimeWindow(5,8)),containsInAnyOrder(new TimeWindow(0,3),new TimeWindow(10,13)),containsInAnyOrder(new TimeWindow(5,8),new TimeWindow(10,13))));
  assertThat(windowSet.getStateWindow(new TimeWindow(0,13)),anyOf(is(new TimeWindow(1,3)),is(new TimeWindow(5,8)),is(new TimeWindow(10,13))));
}
