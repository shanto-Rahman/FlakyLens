@Test public void should_encode_CAS_condition_value() throws Exception {
assertThat(encoded).isInstanceOf(String.class).isEqualTo("COUNTER");
assertThat(CASCondition.getValue()).isEqualTo("COUNTER");
}