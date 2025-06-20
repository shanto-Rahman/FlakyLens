/** 
 * Test destory registry, exporter can be normal by destroyed
 */
@Test public void testDestoryRegistry(){
assertEquals(false,exporter.getInvoker().isAvailable());
}