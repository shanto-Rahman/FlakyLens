@Test public void testMissingSecret(){
  assertThatThrownBy(() -> context.getEnvironment().getProperty("sm://missing-secret/10",String.class)).hasCauseInstanceOf(StatusRuntimeException.class).hasMessageContaining("NOT_FOUND");
}
