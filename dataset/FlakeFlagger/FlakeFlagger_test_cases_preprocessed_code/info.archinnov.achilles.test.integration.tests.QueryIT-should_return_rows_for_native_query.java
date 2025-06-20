@Test public void should_return_rows_for_native_query() throws Exception {
assertThat(actual).hasSize(2);
assertThat(row1.get("name")).isEqualTo("DuyHai");
assertThat(row1.get("age_in_years")).isEqualTo(35L);
assertThat(row1.<List<String>>getTyped("friends")).containsExactly("foo","bar");
assertThat(row1.<Set<String>>getTyped("followers")).contains("George","Paul");
assertThat(preferences1.get(1)).isEqualTo("FR");
assertThat(preferences1.get(2)).isEqualTo("Paris");
assertThat(preferences1.get(3)).isEqualTo("75014");
assertThat(row2.get("name")).isEqualTo("John DOO");
assertThat(row2.get("age_in_years")).isEqualTo(35L);
assertThat(row2.<List<String>>getTyped("friends")).containsExactly("qux","twix");
assertThat(row2.<Set<String>>getTyped("followers")).contains("Isaac","Lara");
assertThat(preferences2.get(1)).isEqualTo("US");
assertThat(preferences2.get(2)).isEqualTo("NewYork");
}