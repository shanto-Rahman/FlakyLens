@Test public void timestamp() throws JoranException, IOException, InterruptedException {
assertNotNull(r);
assertEquals("expected \"" + expected + "\" but got "+ r,expected,r);
}