@Test public void should_bind_for_simple_counter_delete() throws Exception {
assertThat(asList(actual.getValues())).containsExactly("CompleteBean",primaryKey.toString(),"count");
}