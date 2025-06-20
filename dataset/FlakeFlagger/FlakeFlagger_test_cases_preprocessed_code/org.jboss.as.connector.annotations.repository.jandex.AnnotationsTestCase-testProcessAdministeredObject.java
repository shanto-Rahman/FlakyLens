/** 
 * Process: AdministeredObject -- verification of the processAdministeredObject method
 * @throws Throwable  throwable exception
 */
@Test public void testProcessAdministeredObject() throws Throwable {
AnnotationRepository ar=new JandexAnnotationRepositoryImpl(index,Thread.currentThread().getContextClassLoader());
annotations.process(ar,null,Thread.currentThread().getContextClassLoader());
fail(t.getMessage());
}