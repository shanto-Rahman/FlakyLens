@Test public void testGetBeans(){
Assert.assertEquals(1,testBeans.size());
Assert.assertEquals("Hello,World",testBeans.get(0).getName());//IT
}