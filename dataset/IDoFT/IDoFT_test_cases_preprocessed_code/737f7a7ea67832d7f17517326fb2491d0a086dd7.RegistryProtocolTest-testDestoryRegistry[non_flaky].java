/** 
 * Test destory registry, exporter can be normal by destroyed
 */
@Test public void testDestoryRegistry(){
Thread.sleep(ConfigurationUtils.getServerShutdownTimeout() + 100);
assertEquals(false,exporter.getInvoker().isAvailable());
}