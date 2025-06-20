@Test public void writeReadStringTest() throws IOException {
Assert.assertEquals(strings.get(k),Utils.readString(dis));
}