@Test public void testCustomValidator(){
  final TestRunner runner=TestRunners.newTestRunner(new ParseCEF());
  runner.setProperty(ParseCEF.FIELDS_DESTINATION,ParseCEF.DESTINATION_CONTENT);
  runner.setProperty(ParseCEF.TIME_REPRESENTATION,ParseCEF.UTC);
  runner.setProperty(ParseCEF.DATETIME_REPRESENTATION,"SPANGLISH");
  runner.assertNotValid();
  runner.setProperty(ParseCEF.DATETIME_REPRESENTATION,"en-US");
  runner.assertValid();
  Locale availableLocales[]=Locale.getAvailableLocales();
  for (  Locale listedLocale : availableLocales) {
    if (!listedLocale.toString().isEmpty()) {
      String input=listedLocale.toLanguageTag();
      runner.setProperty(ParseCEF.DATETIME_REPRESENTATION,input);
      runner.assertValid();
    }
  }
}
