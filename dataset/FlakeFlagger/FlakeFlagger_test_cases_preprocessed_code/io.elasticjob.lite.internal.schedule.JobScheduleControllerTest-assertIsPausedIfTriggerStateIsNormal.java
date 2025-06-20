@Test public void assertIsPausedIfTriggerStateIsNormal() throws NoSuchFieldException, SchedulerException {
assertFalse(jobScheduleController.isPaused());
}