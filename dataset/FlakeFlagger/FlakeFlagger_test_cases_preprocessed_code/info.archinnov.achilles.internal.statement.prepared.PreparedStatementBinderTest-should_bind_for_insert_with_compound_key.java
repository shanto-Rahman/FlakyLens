@Test public void should_bind_for_insert_with_compound_key() throws Exception {
assertThat(asList(actual.getValues())).containsExactly(userId,name,friends,followers,preferences,0);
}