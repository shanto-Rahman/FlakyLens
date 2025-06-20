/** 
 * Checks that the defaults are loaded when no override is provided.
 */
@Test public void testDefaultsNoOverride(){
assertThat("Default blacklist is not blacklisting some classes",defaultBadClasses,everyItem(is(blacklisted())));
assertThat("Default blacklist is not allowing some classes",defaultOKClasses,everyItem(is(not(blacklisted()))));
}