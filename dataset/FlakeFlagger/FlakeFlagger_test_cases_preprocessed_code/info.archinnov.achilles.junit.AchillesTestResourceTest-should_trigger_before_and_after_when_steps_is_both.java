@Test public void should_trigger_before_and_after_when_steps_is_both() throws Throwable {
assertThat(witness.toString()).isEqualTo("called");
assertThat(witness.toString()).isEqualTo("called");
}