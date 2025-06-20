@Test public void testEquals(){
Assert.assertTrue(element1.equals(element1));
Assert.assertTrue(!element1.equals(element2));
Assert.assertTrue(!element1.equals(element3));
Assert.assertTrue(!element2.equals(element3));
Assert.assertTrue(element3.equals(element4));
Assert.assertTrue(element1.equals(element5));
Assert.assertFalse(element1.equals(null));
Assert.assertFalse(element1.equals("name = value; param1 = value1; param2 = value2"));
}