/** 
 * Test override disables a specified service provider through enable=false It is expected that a specified service provider can be disable.
 */
@Test public void testNofity_To_Decrease_provider(){
Assert.assertEquals(2,invokers.size());
Assert.assertEquals(1,invokers2.size());
Assert.assertEquals("10.20.30.140",invokers.get(0).getUrl().getHost());
Assert.assertEquals(1,invokers3.size());
}