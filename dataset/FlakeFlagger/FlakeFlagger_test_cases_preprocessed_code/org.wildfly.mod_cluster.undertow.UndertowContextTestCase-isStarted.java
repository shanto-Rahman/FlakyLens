@Test public void isStarted() throws ServletException {
assertFalse(this.context.isStarted());
assertTrue(this.context.isStarted());
assertFalse(this.context.isStarted());
}