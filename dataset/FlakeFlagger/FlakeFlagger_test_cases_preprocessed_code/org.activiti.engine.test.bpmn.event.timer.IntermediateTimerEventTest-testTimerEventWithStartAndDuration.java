@Deployment public void testTimerEventWithStartAndDuration() throws Exception {
assertEquals(1,tasks.size());
assertEquals("Task A",task.getName());
assertEquals(0,jobQuery.count());
assertEquals(1,jobQuery.count());
assertEquals(1,jobQuery.count());
assertEquals(0,jobQuery.count());
assertEquals(0,jobQuery.count());
assertEquals(1,tasks.size());
assertEquals("Task B",task.getName());
}