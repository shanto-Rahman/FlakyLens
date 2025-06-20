@Test public void testEquals(){
Assert.assertFalse(param1.equals(param2));
Assert.assertFalse(param1.equals(null));
Assert.assertFalse(param1.equals("name1 = value1"));
Assert.assertTrue(param1.equals(param1));
Assert.assertTrue(param2.equals(param2));
Assert.assertTrue(param1.equals(param3));
}