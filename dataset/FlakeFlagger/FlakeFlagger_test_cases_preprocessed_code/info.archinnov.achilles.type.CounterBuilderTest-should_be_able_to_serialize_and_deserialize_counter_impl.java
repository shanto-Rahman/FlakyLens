@Test public void should_be_able_to_serialize_and_deserialize_counter_impl() throws Exception {
assertThat(serialized).isEqualTo("\"11\"");
assertThat(deserialized.get()).isEqualTo(11L);
assertThat(mapper.writeValueAsString(CounterBuilder.incr(0))).isEqualTo("\"0\"");
}