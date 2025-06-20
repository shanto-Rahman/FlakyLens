@Test public void longTermFailure(){
if (rc.isTooSoon()) {
}
assertEquals(8,tooSoonCount);
}