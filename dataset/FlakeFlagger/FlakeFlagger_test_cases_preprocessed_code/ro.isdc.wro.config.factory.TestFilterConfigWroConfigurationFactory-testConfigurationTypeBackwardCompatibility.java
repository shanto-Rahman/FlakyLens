/** 
 * This test ensures that when "configuration" init-param is used, it will override the debug property for backward compatibility.
 */
@Test public void testConfigurationTypeBackwardCompatibility(){
Assert.assertEquals(false,config.isDebug());
}