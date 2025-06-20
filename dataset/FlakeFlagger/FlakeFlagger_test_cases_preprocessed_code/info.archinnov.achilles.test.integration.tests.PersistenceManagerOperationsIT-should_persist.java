@Test public void should_persist() throws Exception {
assertThat(row.getLong("age_in_years")).isEqualTo(35L);
assertThat(row.getList("friends",String.class)).containsExactly("foo","bar");
assertThat(row.getSet("followers",String.class)).containsOnly("George","Paul");
assertThat(preferences).containsKey(1);
assertThat(preferences).containsKey(2);
assertThat(preferences).containsKey(3);
assertThat(preferences).containsValue("FR");
assertThat(preferences).containsValue("Paris");
assertThat(preferences).containsValue("75014");
assertThat(row.getLong("counter_value")).isEqualTo(15L);
}