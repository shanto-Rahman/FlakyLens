@Test public void createLayoutFromConfigClass() throws Exception {
assertTrue("Wrong result: " + result,result.contains("<title>Content</title>"));
assertTrue("Wrong result: " + result,result.contains("<span>bar</span>"));
}