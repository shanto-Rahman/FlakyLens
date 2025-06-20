@Test void startValidationsShouldFailIfAHealthCheckConfiguredButNotRegistered() throws Exception {
fail("configured health checks that aren't registered should fail");
assertThat(logEvent.getLevel()).isEqualTo(Level.ERROR);
assertThat(logEvent.getFormattedMessage()).doesNotContain("  * check-1");
assertThat(logEvent.getFormattedMessage()).contains("  * check-3");
assertThat(logEvent.getFormattedMessage()).contains("  * check-3");
assertThat(e.getMessage()).contains("[check-3, check-2]");
}