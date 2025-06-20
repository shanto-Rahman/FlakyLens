@Test public void getSpecialResourceViaClassLoader() throws Exception {
assertThat(urlClassLoader.getResource("special/\u00EB.dat"),notNullValue());
}