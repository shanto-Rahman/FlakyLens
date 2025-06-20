/** 
 * Process: ConfigProperty -- verification of the processConfigProperty method
 * @throws Throwable  throwable exception
 */
@Test public void testProcessConfigProperty() throws Throwable {
AnnotationRepository ar=new JandexAnnotationRepositoryImpl(index,Thread.currentThread().getContextClassLoader());
annotations.process(ar,null,Thread.currentThread().getContextClassLoader());
fail(t.getMessage());
}