/** 
 * Test mock invoker selector works as expected
 */
@Test public void testMockedInvokerSelect(){
Assert.assertEquals(1,mockedInvokers.size());
Assert.assertEquals(5,invokers.size());
}