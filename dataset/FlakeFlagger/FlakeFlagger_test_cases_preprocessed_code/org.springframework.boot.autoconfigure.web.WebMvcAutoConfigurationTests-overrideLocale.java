@Test public void overrideLocale() throws Exception {
assertThat(localeResolver,instanceOf(FixedLocaleResolver.class));
assertThat(locale.toString(),equalTo("en_UK"));
}