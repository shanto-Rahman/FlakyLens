@Test public void should_return_null_when_no_simple_counter_value() throws Exception {
assertThat(facade.getSimpleCounter(counterMeta,LOCAL_QUORUM)).isNull();
}