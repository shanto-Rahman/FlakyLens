@Test public void noName(){
assertEquals(1,context.getStatusManager().getCount());
assertTrue(checkError());
}