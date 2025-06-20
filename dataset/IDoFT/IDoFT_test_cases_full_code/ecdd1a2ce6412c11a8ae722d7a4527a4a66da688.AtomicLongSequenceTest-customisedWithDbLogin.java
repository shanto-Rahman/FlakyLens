@Test public void customisedWithDbLogin() throws Exception {
  Session session=mock(Session.class);
  DatabaseLogin databaseLogin=mock(DatabaseLogin.class);
  when(session.getLogin()).thenReturn(databaseLogin);
  AtomicLongSequence atomicLongSequence=new AtomicLongSequence();
  atomicLongSequence.customize(session);
  verify(databaseLogin).addSequence(atomicLongSequence);
  verify(session).getLogin();
  verifyNoMoreInteractions(session,databaseLogin);
}
