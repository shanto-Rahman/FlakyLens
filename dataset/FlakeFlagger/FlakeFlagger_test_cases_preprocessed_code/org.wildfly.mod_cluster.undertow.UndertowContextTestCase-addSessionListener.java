@Test public void addSessionListener() throws ServletException {
assertSame(session,event.getValue().getSession());
assertSame(session,event.getValue().getSession());
}