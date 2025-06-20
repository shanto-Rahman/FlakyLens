@Test public void customisedWithNullDbLogin() throws Exception {
  Session session=mock(Session.class);
  AtomicLongSequence atomicLongSequence=new AtomicLongSequence();
  atomicLongSequence.customize(session);
  verify(session).getLogin();
  verifyNoMoreInteractions(session);
}
