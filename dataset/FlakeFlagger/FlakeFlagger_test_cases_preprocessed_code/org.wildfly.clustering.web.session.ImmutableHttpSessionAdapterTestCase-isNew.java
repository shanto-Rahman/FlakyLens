@Test public void isNew(){
assertTrue(this.httpSession.isNew());
assertFalse(this.httpSession.isNew());
}