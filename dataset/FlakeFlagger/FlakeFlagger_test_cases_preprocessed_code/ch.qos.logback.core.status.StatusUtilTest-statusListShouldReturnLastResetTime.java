@Test public void statusListShouldReturnLastResetTime(){
assertTrue(resetTime <= statusUtil.timeOfLastReset());
}