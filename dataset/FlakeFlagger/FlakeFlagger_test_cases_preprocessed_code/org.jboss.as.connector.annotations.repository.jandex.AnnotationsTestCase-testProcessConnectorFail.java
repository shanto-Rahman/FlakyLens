/** 
 * Process: Connector -- verification of the processConnector method
 * @throws Throwable  throwable exception
 */
@Test public void testProcessConnectorFail() throws Throwable {
AnnotationRepository ar=new JandexAnnotationRepositoryImpl(index,Thread.currentThread().getContextClassLoader());
annotations.process(ar,null,Thread.currentThread().getContextClassLoader());
fail("Success");
}