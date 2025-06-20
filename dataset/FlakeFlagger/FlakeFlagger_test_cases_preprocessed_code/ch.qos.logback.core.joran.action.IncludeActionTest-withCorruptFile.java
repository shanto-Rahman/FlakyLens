@Test public void withCorruptFile() throws JoranException, IOException {
assertEquals(Status.ERROR,statusChecker.getHighestLevel(0));
assertTrue(statusChecker.containsException(SAXParseException.class));
File f=new File(tmpOut);//RO
assertTrue(f.exists());
assertTrue(f.delete());
}