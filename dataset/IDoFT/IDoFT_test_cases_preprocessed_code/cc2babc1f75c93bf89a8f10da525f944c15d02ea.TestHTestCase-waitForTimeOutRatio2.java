@Test public void waitForTimeOutRatio2(){
assertEquals(waited,-1);
assertEquals(end - start,200 * getWaitForRatio(),50 * getWaitForRatio());
}