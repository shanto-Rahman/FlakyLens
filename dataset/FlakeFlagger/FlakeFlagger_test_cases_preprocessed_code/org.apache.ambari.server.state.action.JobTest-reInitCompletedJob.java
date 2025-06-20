@Test public void reInitCompletedJob() throws Exception {
Assert.assertEquals(ActionState.INIT,job.getState());
Assert.assertEquals(100,job.getStartTime());
Assert.assertEquals(-1,job.getLastUpdateTime());
Assert.assertEquals(-1,job.getCompletionTime());
Assert.assertEquals(2,job.getId().actionId);
}