@Test public void testObject(){
Assert.assertEquals(map,context.get());
Assert.assertEquals("1111",context.get("_11"));
Assert.assertEquals("11.11",context.get("_11"));
Assert.assertEquals("22222",context.get(null));
Assert.assertNull(context.get("_22"));
Assert.assertNull(context.get("_33"));
Assert.assertEquals("3333",context.get(".33"));
Assert.assertNull(context.get("_11"));
}