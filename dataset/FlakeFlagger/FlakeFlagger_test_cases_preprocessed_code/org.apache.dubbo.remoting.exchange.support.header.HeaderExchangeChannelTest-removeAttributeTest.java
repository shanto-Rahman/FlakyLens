@Test public void removeAttributeTest(){
Assert.assertEquals(header.getAttribute("test"),"test");
Assert.assertFalse(header.hasAttribute("test"));
}