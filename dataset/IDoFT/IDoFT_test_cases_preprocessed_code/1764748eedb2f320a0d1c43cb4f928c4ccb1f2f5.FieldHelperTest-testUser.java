@Test public void testUser(){
Assert.assertEquals(2,fieldList.size());
Assert.assertEquals("id",fieldList.get(0).getName());
Assert.assertEquals("name",fieldList.get(1).getName());
}