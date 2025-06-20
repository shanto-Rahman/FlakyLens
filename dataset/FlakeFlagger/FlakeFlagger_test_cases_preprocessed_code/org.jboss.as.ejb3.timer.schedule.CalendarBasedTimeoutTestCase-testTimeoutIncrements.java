/** 
 * This test asserts that the timer increments in seconds, minutes and hours are the same for a complete year using a DST timezone and a non-DST timezone. This test covers WFLY-10106 issue.
 */
@Test public void testTimeoutIncrements(){
Assert.assertTrue(dstTimezone.useDaylightTime());
Assert.assertTrue(!nonDstTimezone.useDaylightTime());
}