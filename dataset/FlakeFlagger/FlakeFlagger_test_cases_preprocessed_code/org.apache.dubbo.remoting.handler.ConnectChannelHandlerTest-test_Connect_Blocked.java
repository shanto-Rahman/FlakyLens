@Test public void test_Connect_Blocked() throws RemotingException {
Assert.assertEquals(1,executor.getMaximumPoolSize());
Assert.assertTrue(executor.getActiveCount() + " must <=1",executor.getActiveCount() <= 1);
Assert.assertEquals(taskCount - 1,executor.getQueue().size());
if (executor.getCompletedTaskCount() < taskCount) {
}
Assert.assertEquals(taskCount,executor.getCompletedTaskCount());
}