@Test public void assertInit() throws NoSuchFieldException, SchedulerException {
assertThat(scheduler.getListenerManager().getTriggerListeners().get(0),instanceOf(JobTriggerListener.class));
assertTrue(scheduler.isStarted());
}