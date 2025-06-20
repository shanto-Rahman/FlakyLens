/** 
 * Process: AuthenticationMechanism -- verification of the processAuthenticationMechanism method
 * @throws Throwable  throwable exception
 */
@Test public void testProcessAuthenticationMechanism() throws Throwable {
AnnotationRepository ar=new JandexAnnotationRepositoryImpl(index,Thread.currentThread().getContextClassLoader());
annotations.process(ar,null,Thread.currentThread().getContextClassLoader());
fail(t.getMessage());
}