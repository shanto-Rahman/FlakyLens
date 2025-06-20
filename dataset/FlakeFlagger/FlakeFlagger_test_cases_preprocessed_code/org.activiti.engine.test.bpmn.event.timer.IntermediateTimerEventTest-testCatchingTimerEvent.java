@Deployment public void testCatchingTimerEvent() throws Exception {
assertEquals(1,jobQuery.count());
assertEquals(0,jobQuery.count());
}