@Test public void testSepculateSuccessfulWithUpdateEvents() throws Exception {
Assert.assertEquals("Num tasks is not correct",NUM_MAPPERS + NUM_REDUCERS,tasks.size());
if (numTasksToFinish > 0) {
}
if (taskAttempt.getValue().getState() != TaskAttemptState.SUCCEEDED) {
}
if (speculatedTaskConst.getAttempts().size() != 2) {
}
}