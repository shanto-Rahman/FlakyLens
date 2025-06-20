@Test public void hasAttributeTest(){
Assert.assertFalse(header.hasAttribute("test"));
Assert.assertTrue(header.hasAttribute("test"));
}