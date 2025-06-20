@Test public void testNlLanginfo() throws Throwable {
  if (!Platform.IS_WINDOWS) {
    InputStreamReader isr=null;
    BufferedReader reader=null;
    try {
      isr=new InputStreamReader(Runtime.getRuntime().exec("locale charmap").getInputStream());
      reader=new BufferedReader(isr);
      String localeCharmap=reader.readLine();
      assertEquals(localeCharmap,posix.nl_langinfo(LangInfo.CODESET.intValue()));
    }
  finally {
      if (reader != null) {
        reader.close();
      }
      if (isr != null) {
        isr.close();
      }
    }
  }
}
