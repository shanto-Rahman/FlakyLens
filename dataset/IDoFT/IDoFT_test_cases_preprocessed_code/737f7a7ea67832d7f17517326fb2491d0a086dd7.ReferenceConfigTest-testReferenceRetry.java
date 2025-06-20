/** 
 * unit test for dubbo-1765
 */
@Test public void testReferenceRetry(){
Assert.assertFalse(success);
Assert.assertNull(demoService);
Assert.assertTrue(success);
Assert.assertNotNull(demoService);
}