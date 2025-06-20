@Test public void should_bind_for_clustered_counter_delete() throws Exception {
assertThat(asList(actual.getValues())).containsExactly(primaryKey);
}