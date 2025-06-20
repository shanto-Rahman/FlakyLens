@Test public void testObject(){
Assertions.assertEquals(map,context.get());
Assertions.assertEquals("1111",context.get("_11"));
Assertions.assertEquals("11.11",context.get("_11"));
Assertions.assertEquals("22222",context.get(null));
Assertions.assertNull(context.get("_22"));
Assertions.assertNull(context.get("_33"));
Assertions.assertEquals("3333",context.get(".33"));
Assertions.assertNull(context.get("_11"));
}