/** 
 * Test override disables a specified service provider through enable=false It is expected that a specified service provider can be disable.
 */
@Test public void testNofity_disabled_specifiedProvider(){
Assert.assertEquals(1,invokers.size());
Assert.assertEquals("10.20.30.141",invokers.get(0).getUrl().getHost());
Assert.assertEquals(2,invokers2.size());
}