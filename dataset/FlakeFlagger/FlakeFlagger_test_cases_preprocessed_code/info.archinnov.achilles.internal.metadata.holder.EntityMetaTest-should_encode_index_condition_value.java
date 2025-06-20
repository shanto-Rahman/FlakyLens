@Test public void should_encode_index_condition_value() throws Exception {
assertThat(encoded).isInstanceOf(String.class).isEqualTo("COUNTER");
assertThat(indexCondition.getColumnValue()).isEqualTo("COUNTER");
}