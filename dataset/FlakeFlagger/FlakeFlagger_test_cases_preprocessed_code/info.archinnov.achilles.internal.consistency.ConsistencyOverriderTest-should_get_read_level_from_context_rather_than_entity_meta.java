@Test public void should_get_read_level_from_context_rather_than_entity_meta() throws Exception {
assertThat(actual).isEqualTo(EACH_QUORUM);
}