@Test public void should_trigger_only_before_when_steps_is_before() throws Throwable {
assertThat(witness.toString()).isEqualTo("called");
assertThat(witness.toString()).isEmpty();
}