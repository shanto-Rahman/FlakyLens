@Test public void assertIsPauseJobIfShutdown() throws NoSuchFieldException, SchedulerException {
assertFalse(jobScheduleController.isPaused());
}