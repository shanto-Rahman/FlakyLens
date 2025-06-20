@Test public void should_bind_for_clustered_counter_increment_decrement() throws Exception {
assertThat(asList(actual.getValues())).containsExactly(0,counter,primaryKey);
}