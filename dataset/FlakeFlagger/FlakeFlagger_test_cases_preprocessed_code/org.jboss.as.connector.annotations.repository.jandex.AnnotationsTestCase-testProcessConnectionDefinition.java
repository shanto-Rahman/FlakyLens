/** 
 * Process: ConnectionDefinition -- verification of the processConnectionDefinition method
 * @throws Throwable  throwable exception
 */
@Test public void testProcessConnectionDefinition() throws Throwable {
AnnotationRepository ar=new JandexAnnotationRepositoryImpl(index,Thread.currentThread().getContextClassLoader());
annotations.process(ar,null,Thread.currentThread().getContextClassLoader());
fail(t.getMessage());
}