@Test public void testHttpCore239() throws Exception {
channel.write(wrap("0123456789ABCDEF"));//IT
Assert.assertEquals(0,encoder.write(src));
Assert.assertEquals(0,encoder.write(src));
Assert.assertEquals(0,encoder.write(src));
channel.reset();//IT
channel.reset();//IT
Assert.assertEquals(4,encoder.write(src));
channel.flush();//IT
Assert.assertEquals(4,encoder.write(src));
channel.flush();//IT
Assert.assertEquals(4,encoder.write(src));
channel.flush();//IT
Assert.assertEquals(4,encoder.write(src));
channel.flush();//IT
Assert.assertEquals(0,encoder.write(src));
String s=channel.toString("US-ASCII");//IT
Assert.assertEquals("4\r\n0123\r\n4\r\n4567\r\n4\r\n89AB\r\n4\r\nCDEF\r\n",s);
}