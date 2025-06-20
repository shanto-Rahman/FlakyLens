@Test public void testNVParseAllWithCursor(){
Assert.assertEquals("test",params[0].getName());
Assert.assertEquals(null,params[0].getValue());
Assert.assertEquals("test1",params[1].getName());
Assert.assertEquals("stuff",params[1].getValue());
Assert.assertEquals("test2",params[2].getName());
Assert.assertEquals("stuff; stuff",params[2].getValue());
Assert.assertEquals("test3",params[3].getName());
Assert.assertEquals("\"stuff",params[3].getValue());
Assert.assertEquals(s.length(),cursor.getPos());
Assert.assertTrue(cursor.atEnd());
Assert.assertEquals("test",params[0].getName());
Assert.assertEquals(null,params[0].getValue());
Assert.assertEquals("test1",params[1].getName());
Assert.assertEquals("stuff",params[1].getValue());
Assert.assertEquals("test2",params[2].getName());
Assert.assertEquals("stuff; stuff",params[2].getValue());
Assert.assertEquals("test3",params[3].getName());
Assert.assertEquals("stuff",params[3].getValue());
Assert.assertEquals(s.length() - 3,cursor.getPos());
Assert.assertFalse(cursor.atEnd());
Assert.assertEquals(0,params.length);
}