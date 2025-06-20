@Test public void testDeleteByIds(){
Assert.assertEquals(3,count);
Assert.assertEquals(180,mapper.selectCount(null));
}