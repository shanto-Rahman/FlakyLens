@Test public void testConstruction(){
Assert.assertTrue(slice.getColumns().isEmpty());
Assert.assertEquals(1,slice.getColumns().size());
Assert.assertEquals((Long)1L,slice.getColumnByName("1").getValue());
}