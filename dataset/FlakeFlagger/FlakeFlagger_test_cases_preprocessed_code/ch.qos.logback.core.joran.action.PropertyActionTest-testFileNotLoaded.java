@Test public void testFileNotLoaded(){
assertEquals(1,context.getStatusManager().getCount());
assertTrue(checkError());
}