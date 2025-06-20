@Test public void testNlLanginfo() throws Throwable {
if (!Platform.IS_WINDOWS) {
assertEquals(localeCharmap,posix.nl_langinfo(LangInfo.CODESET.intValue()));//RW
if (reader != null) {
}
if (isr != null) {
}
}
}