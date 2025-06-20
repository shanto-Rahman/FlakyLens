@Test public void testV2ListImageTags() throws Throwable {
assertNotNull("result is null",tags);
assertArrayEquals(new String[]{"7.1","7.2","7.3","7.4"},tags);
}