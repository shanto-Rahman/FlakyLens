@Test public void should_not_consume_iterator_when_asserting_non_null() throws Exception {
assertThat(iterator).isNotNull();
}