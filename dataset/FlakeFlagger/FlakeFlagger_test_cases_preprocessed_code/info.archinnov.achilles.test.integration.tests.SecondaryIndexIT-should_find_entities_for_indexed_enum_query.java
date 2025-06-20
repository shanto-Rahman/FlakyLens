@Test public void should_find_entities_for_indexed_enum_query() throws Exception {
assertThat(actual).hasSize(2);
assertThat(found1.getId()).isEqualTo(10L);
assertThat(found2.getId()).isEqualTo(11L);
}