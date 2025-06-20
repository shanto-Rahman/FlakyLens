@Test public void testWriteTo() throws Exception {
FileOutputStream outstream=new FileOutputStream(tmpfile);
Assert.assertNotNull(bytes);
Assert.assertEquals(tmpfile.length(),bytes.length);
Assert.assertEquals(i,bytes[i]);
if (!tmpfile.delete()) {
Assert.fail("Failed to delete: " + tmpfile);
}
Assert.fail("IllegalArgumentException should have been thrown");
}