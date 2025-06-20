@Test public void bindsSystemPropertyToSpringApplication() throws Exception {
assertThat((Boolean)field.get(application),equalTo(false));
}