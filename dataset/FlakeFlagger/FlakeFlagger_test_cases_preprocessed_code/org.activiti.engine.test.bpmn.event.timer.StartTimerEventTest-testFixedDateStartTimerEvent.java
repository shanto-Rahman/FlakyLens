@Deployment public void testFixedDateStartTimerEvent() throws Exception {
assertEquals(1,jobQuery.count());
assertEquals(1,pi.size());
assertEquals(0,jobQuery.count());
}