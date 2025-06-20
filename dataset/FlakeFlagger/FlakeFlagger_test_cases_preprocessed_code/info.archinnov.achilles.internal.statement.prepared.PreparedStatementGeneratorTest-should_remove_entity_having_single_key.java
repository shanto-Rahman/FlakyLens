@Test public void should_remove_entity_having_single_key() throws Exception {
assertThat(actual).hasSize(1);
assertThat(actual).containsValue(ps);
assertThat(queryCaptor.getValue()).isEqualTo("DELETE  FROM table WHERE id=:id;");
}