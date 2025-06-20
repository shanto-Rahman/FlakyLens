@Test public void should_trigger_only_after_when_steps_is_after() throws Throwable {
assertThat(witness.toString()).isEqualTo("called");
assertThat(witness.toString()).isEmpty();
}