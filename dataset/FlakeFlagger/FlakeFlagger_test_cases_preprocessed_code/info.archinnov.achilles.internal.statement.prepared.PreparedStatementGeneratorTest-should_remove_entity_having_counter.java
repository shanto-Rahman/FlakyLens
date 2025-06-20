@Test public void should_remove_entity_having_counter() throws Exception {
assertThat(actual).hasSize(1);
assertThat(actual).containsKey("table");
assertThat(actual).containsValue(ps);
assertThat(queryCaptor.getAllValues()).containsOnly("DELETE  FROM table WHERE id=:id;");
}