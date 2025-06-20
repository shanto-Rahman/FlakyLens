@Test public void testSubDelete(){
assertEquals(3,scq.execute().get().getColumns().size());
assertEquals(2,scq.execute().get().getColumns().size());
}