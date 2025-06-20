@Test public void should_find_accessors_from_counter_type() throws Exception {
assertThat(accessors).hasSize(2);
assertThat(accessors[0].getName()).isEqualTo("getCount");
assertThat(accessors[1].getName()).isEqualTo("setCount");
}