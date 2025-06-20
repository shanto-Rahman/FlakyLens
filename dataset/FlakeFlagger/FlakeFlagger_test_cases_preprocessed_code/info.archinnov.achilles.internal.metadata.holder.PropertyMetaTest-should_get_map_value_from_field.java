@Test public void should_get_map_value_from_field() throws Exception {
assertThat(actual).containsKey(1).containsKey(2).containsValue("FR").containsValue("Paris");
}