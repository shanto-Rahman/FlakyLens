/** 
 * Checks that the overrides are loaded when the property is provided and the file exists.
 */
@Test public void testDefaultsOverrideExists() throws Exception {
try (FileOutputStream fos=new FileOutputStream(f))
assertThat("Default blacklist should not be used",defaultBadClasses,everyItem(is(not(blacklisted()))));
assertThat("Custom blacklist should be used",badClasses,everyItem(is(blacklisted())));
assertThat("Custom blacklist is not allowing some classes",defaultOKClasses,everyItem(is(not(blacklisted()))));
}