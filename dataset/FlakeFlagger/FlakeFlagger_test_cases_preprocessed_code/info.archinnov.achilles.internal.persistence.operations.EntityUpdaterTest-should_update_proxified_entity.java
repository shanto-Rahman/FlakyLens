@Test public void should_update_proxified_entity() throws Exception {
assertThat(pmCaptor.getValue()).containsOnly(pm);
}