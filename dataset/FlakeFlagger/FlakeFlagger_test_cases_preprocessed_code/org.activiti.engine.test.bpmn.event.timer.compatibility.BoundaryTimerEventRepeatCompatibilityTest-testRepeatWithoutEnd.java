@Deployment public void testRepeatWithoutEnd() throws Throwable {
assertEquals(1,tasks.size());
assertEquals("Task A",task.getName());
assertEquals(1,jobs.size());
assertEquals(1,jobs.size());
assertEquals(1,jobs.size());
fail("Should not have any other jobs because the endDate is reached");
assertEquals("Task B",task.getName());
assertEquals(1,tasks.size());
fail("No jobs should be active here.");
assertEquals(0,processInstances.size());
assertEquals(0,jobs.size());
assertEquals(0,jobs.size());
assertEquals(0,tasks.size());
}