@Test public void noValue(){
assertEquals(1,context.getStatusManager().getCount());
assertTrue(checkError());
}