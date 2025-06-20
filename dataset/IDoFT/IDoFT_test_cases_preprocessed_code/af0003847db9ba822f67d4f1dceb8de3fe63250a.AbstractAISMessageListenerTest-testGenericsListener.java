@Test public void testGenericsListener(){
assertEquals(gl.received.toString(),MSG_01.toString());
assertEquals("1",gl.dummy(1));
}