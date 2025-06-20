@Test public void testRootContextWAR(@ArquillianResource URL url) throws Exception {
String response=RootContextUtil.hitRootContext(url,HOST);//RW
assertTrue(response.contains("A Root Context Page"));
}