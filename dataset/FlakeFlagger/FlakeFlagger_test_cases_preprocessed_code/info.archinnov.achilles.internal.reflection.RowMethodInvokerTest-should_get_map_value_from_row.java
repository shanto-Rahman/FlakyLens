@SuppressWarnings({"unchecked","rawtypes"}) @Test public void should_get_map_value_from_row() throws Exception {
assertThat((Map)actual).containsKey(11);
assertThat((Map)actual).containsValue("value");
}