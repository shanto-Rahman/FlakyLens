@Deployment public void testCatchingTimerEvent() throws Exception {
assertEquals(3,jobQuery.count());
assertEquals(0,jobQuery.count());
}