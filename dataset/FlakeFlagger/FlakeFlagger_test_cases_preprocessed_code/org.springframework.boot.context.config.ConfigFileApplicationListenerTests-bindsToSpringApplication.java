@Test public void bindsToSpringApplication() throws Exception {
assertThat((Boolean)field.get(application),equalTo(false));
}