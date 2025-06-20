@Test public void objectToJSon() throws IOException {
assertEquals(json,toJson(davidTuranski));
assertEquals(toJson(davidTuranski),result);
}