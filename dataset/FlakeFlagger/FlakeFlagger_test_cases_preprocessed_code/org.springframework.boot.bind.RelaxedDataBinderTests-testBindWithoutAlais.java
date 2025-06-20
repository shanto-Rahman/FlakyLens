@Test public void testBindWithoutAlais() throws Exception {
assertThat(target.getFooBaz(),nullValue());
assertThat(target.getFoo(),equalTo("b"));
}