@Test public void testBuildIndexKeys(){
assertTrue(Bytes.equals(indexKeys.getFirst(),first) || Bytes.equals(indexKeys.getFirst(),second));
assertTrue(indexs.contains(indexKeys.getSecond()));
}