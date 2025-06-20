@Test public void should_return_true_for_is_component_time_uuid() throws Exception {
assertThat(pm.isPrimaryKeyTimeUUID("comp1")).isTrue();
assertThat(pm.isPrimaryKeyTimeUUID("comp2")).isFalse();
}