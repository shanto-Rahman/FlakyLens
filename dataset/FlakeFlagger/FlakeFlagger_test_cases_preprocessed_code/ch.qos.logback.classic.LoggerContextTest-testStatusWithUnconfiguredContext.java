@Test public void testStatusWithUnconfiguredContext(){
assertTrue("StatusManager has recieved too many messages",sm.getCount() == 1);
}