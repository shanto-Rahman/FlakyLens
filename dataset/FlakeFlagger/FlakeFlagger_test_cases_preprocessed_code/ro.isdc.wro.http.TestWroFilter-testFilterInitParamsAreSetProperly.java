/** 
 * Set filter init params with proper values and check they are the same in    {@link WroConfiguration}  object.
 */
@Test public void testFilterInitParamsAreSetProperly() throws Exception {
Assert.assertEquals(false,config.isDebug());
Assert.assertEquals(false,config.isGzipEnabled());
Assert.assertEquals(10,config.getCacheUpdatePeriod());
Assert.assertEquals(100,config.getModelUpdatePeriod());
}