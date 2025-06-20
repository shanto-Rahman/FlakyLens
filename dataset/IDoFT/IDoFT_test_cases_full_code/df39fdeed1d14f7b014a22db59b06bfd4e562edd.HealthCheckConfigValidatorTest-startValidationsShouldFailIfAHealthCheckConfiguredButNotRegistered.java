@Test void startValidationsShouldFailIfAHealthCheckConfiguredButNotRegistered() throws Exception {
  ArgumentCaptor<LoggingEvent> captor=ArgumentCaptor.forClass(LoggingEvent.class);
  List<HealthCheckConfiguration> configs=new ArrayList<>();
  HealthCheckConfiguration check1=new HealthCheckConfiguration();
  check1.setName("check-1");
  configs.add(check1);
  HealthCheckConfiguration check2=new HealthCheckConfiguration();
  check2.setName("check-2");
  configs.add(check2);
  HealthCheckConfiguration check3=new HealthCheckConfiguration();
  check3.setName("check-3");
  configs.add(check3);
  HealthCheckRegistry registry=new HealthCheckRegistry();
  registry.register("check-1",mock(HealthCheck.class));
  try {
    HealthCheckConfigValidator validator=new HealthCheckConfigValidator(unmodifiableList(configs),registry);
    validator.start();
    fail("configured health checks that aren't registered should fail");
  }
 catch (  IllegalStateException e) {
    verify(mockLogAppender).doAppend(captor.capture());
    LoggingEvent logEvent=captor.getValue();
    assertThat(logEvent.getLevel()).isEqualTo(Level.ERROR);
    assertThat(logEvent.getFormattedMessage()).doesNotContain("  * check-1");
    assertThat(logEvent.getFormattedMessage()).contains("  * check-3");
    assertThat(logEvent.getFormattedMessage()).contains("  * check-3");
    assertThat(e.getMessage()).contains("[check-3, check-2]");
  }
}
