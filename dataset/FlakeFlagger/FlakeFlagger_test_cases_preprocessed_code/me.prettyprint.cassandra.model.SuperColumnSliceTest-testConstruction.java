@Test public void testConstruction(){
Assert.assertTrue(slice.getSuperColumns().isEmpty());
Assert.assertEquals(1,slice.getSuperColumns().size());
Assert.assertEquals((Long)5L,slice.getColumnByName("super").get(0).getName());
}