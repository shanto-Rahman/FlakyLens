@Test public void testAttachments(){
Assert.assertEquals(map,context.getAttachments());
Assert.assertEquals("1111",context.getAttachment("_11"));
Assert.assertEquals("11.11",context.getAttachment("_11"));
Assert.assertEquals("22222",context.getAttachment(null));
Assert.assertNull(context.getAttachment("_22"));
Assert.assertNull(context.getAttachment("_33"));
Assert.assertEquals("3333",context.getAttachment(".33"));
Assert.assertNull(context.getAttachment("_11"));
}