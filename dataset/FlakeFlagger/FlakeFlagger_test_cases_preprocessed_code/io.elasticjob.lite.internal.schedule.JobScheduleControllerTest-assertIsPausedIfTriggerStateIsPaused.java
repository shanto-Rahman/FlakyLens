@Test public void assertIsPausedIfTriggerStateIsPaused() throws NoSuchFieldException, SchedulerException {
assertTrue(jobScheduleController.isPaused());
}