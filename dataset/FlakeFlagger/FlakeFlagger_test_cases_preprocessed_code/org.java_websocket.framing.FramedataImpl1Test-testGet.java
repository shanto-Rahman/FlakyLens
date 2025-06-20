@Test public void testGet(){
assertEquals("Frame must be binary",true,binary instanceof BinaryFrame);
assertEquals("Frame must be text",true,text instanceof TextFrame);
assertEquals("Frame must be closing",true,closing instanceof CloseFrame);
assertEquals("Frame must be continuous",true,continuous instanceof ContinuousFrame);
assertEquals("Frame must be ping",true,ping instanceof PingFrame);
assertEquals("Frame must be pong",true,pong instanceof PongFrame);
fail("IllegalArgumentException should be thrown");
}