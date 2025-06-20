@Test public void should_bind_for_simple_counter_increment_decrement() throws Exception {
assertThat(asList(actual.getValues())).containsExactly(counter,"CompleteBean",primaryKey.toString(),"count");
}