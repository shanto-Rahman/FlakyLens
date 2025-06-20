@Test public void should_parse_embedded_id_with_time_uuid() throws Exception {
assertThat(props.getTimeUUIDComponents()).containsExactly("date");
assertThat(props.getComponentNames()).containsExactly("date","ranking");
}