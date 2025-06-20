@Test public void should_bind_for_clustered_counter_select() throws Exception {
assertThat(asList(actual.getValues())).containsExactly(primaryKey);
}