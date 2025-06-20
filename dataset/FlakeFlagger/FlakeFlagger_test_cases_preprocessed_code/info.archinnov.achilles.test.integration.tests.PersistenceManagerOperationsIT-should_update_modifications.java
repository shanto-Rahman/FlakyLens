@Test public void should_update_modifications() throws Exception {
assertThat(row.getLong("age_in_years")).isEqualTo(100L);
assertThat(row.getList("friends",String.class)).containsExactly("bob","alice","eve");
assertThat(preferences.get(1)).isEqualTo("FR");
assertThat(preferences.get(2)).isEqualTo("New York");
}