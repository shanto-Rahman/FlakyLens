@Test public void getAttributeAndSetAttributeTest(){
Assert.assertEquals(header.getAttribute("test"),"test");
Assert.assertTrue(header.hasAttribute("test"));
}