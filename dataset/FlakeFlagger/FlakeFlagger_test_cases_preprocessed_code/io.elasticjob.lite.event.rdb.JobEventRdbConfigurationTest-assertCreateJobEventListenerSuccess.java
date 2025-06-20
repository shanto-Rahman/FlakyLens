@Test public void assertCreateJobEventListenerSuccess() throws JobEventListenerConfigurationException {
assertThat(new JobEventRdbConfiguration(dataSource).createJobEventListener(),instanceOf(JobEventRdbListener.class));
}