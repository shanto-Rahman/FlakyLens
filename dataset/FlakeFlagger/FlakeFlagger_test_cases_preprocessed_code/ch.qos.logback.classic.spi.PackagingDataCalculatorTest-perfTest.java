@Test public void perfTest(){
if (!SystemInfo.getJavaVendor().contains("Sun")) {
}
assertTrue("computing class packaging data (" + d1 + ") should have been less than "+ slackFactor+ " times the time it takes to process an exception "+ (d0 * slackFactor),d0 * slackFactor > d1);
}