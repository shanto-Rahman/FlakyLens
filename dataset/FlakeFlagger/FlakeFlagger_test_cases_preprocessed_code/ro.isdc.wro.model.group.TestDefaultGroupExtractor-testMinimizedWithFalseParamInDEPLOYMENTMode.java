/** 
 * Test that in DEPLOYMENT mode, the minimize flag cannot be false, no matter what parameter value is supplied.
 */
@Test public void testMinimizedWithFalseParamInDEPLOYMENTMode(){
assertTrue(groupExtractor.isMinimized(request));
}