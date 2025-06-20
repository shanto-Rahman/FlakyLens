/** 
 * This test checks that the pattern layout implementation starts its converters. ExceptionalConverter throws an exception if it's convert method is called before being started.
 */
@Test public void testConverterStart(){
assertFalse(result.contains("%PARSER_ERROR_EX"));
}