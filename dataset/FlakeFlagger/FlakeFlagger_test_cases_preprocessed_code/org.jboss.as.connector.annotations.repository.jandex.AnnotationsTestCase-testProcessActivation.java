/** 
 * Process: Activation -- verification of the processActivation method
 * @throws Throwable  throwable exception
 */
@Test public void testProcessActivation() throws Throwable {
AnnotationRepository ar=new JandexAnnotationRepositoryImpl(index,Thread.currentThread().getContextClassLoader());
annotations.process(ar,null,Thread.currentThread().getContextClassLoader());
fail(t.getMessage());
}