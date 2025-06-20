/** 
 * Process: ConnectionDefinitions -- verification of the processConnectionDefinitions method
 * @throws Throwable  throwable exception
 */
@Test public void testProcessConnectionDefinitions() throws Throwable {
AnnotationRepository ar=new JandexAnnotationRepositoryImpl(index,Thread.currentThread().getContextClassLoader());
annotations.process(ar,null,Thread.currentThread().getContextClassLoader());
fail(t.getMessage());
}