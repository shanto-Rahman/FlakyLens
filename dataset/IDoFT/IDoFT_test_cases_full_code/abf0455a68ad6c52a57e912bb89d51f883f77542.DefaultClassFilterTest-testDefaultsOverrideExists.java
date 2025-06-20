/** 
 * Checks that the overrides are loaded when the property is provided and the file exists.
 */
@Test public void testDefaultsOverrideExists() throws Exception {
  List<String> badClasses=Arrays.asList("eric.Clapton","john.winston.ono.Lennon","jimmy.Page");
  File f=folder.newFile("overrides.txt");
  try (FileOutputStream fos=new FileOutputStream(f)){
    for (    String s : badClasses) {
      IOUtils.write(s,fos);
      IOUtils.write("\n",fos);
    }
  }
   setOverrideProperty(f.getAbsolutePath());
  assertThat("Default blacklist should not be used",defaultBadClasses,everyItem(is(not(blacklisted()))));
  assertThat("Custom blacklist should be used",badClasses,everyItem(is(blacklisted())));
  assertThat("Custom blacklist is not allowing some classes",defaultOKClasses,everyItem(is(not(blacklisted()))));
}
