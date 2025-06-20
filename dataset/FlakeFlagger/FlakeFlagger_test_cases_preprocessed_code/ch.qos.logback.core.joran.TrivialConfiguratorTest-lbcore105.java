@Test public void lbcore105() throws IOException, JoranException {
assertTrue(jarFile.delete());
assertFalse(jarFile.exists());
}