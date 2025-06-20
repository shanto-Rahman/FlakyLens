/** 
 * Test that multiple calls do not generate the same clock (timestamp)
 */
@Test public void testMicrosecondsSync() throws Exception {
if (current == previous) {
fail("Two calls to clock generated the same timestamp. (previous=" + previous + " - current="+ current+ "). Cycle:"+ i);
}
}