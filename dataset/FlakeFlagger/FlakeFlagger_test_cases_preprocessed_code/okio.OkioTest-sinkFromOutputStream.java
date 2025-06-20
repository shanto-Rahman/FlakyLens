@Test public void sinkFromOutputStream() throws Exception {
assertEquals("abb",out.toString("UTF-8"));
assertEquals("a" + repeat('b',9998) + "c",out.toString("UTF-8"));
}