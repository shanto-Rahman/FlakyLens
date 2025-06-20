@Deployment public void testCycleWithLimitStartTimerEvent() throws Exception {
assertEquals(1,jobQuery.count());
assertEquals(1,jobQuery.count());
assertEquals(0,jobQuery.count());
}