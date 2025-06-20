@Test public void testRpcFilter() throws Exception {
Assert.assertEquals("123",service.echo("123"));
Assert.assertEquals(echo.$echo("test"),"test");
Assert.assertEquals(echo.$echo("abcdefg"),"abcdefg");
Assert.assertEquals(echo.$echo(1234),1234);
}