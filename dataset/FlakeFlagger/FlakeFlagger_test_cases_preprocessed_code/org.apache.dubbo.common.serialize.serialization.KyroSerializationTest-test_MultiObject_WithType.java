@Test public void test_MultiObject_WithType() throws Exception {
assertEquals(false,deserialize.readBool());
assertEquals(bigPerson,deserialize.readObject(BigPerson.class));
assertEquals((byte)23,deserialize.readByte());
assertEquals(mediaContent,deserialize.readObject(MediaContent.class));
assertEquals(-23,deserialize.readInt());
fail();
}