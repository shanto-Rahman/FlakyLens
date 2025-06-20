@Test public void noAttributes(){
assertEquals(1,context.getStatusManager().getCount());
assertTrue(checkError());
}