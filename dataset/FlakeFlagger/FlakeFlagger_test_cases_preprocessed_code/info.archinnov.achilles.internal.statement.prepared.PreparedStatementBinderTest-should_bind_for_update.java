@Test public void should_bind_for_update() throws Exception {
assertThat(asList(actual.getValues())).containsExactly(0,name,age,primaryKey);
}