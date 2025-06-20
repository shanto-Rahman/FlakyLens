@Test public void primitivePairs() throws Exception {
if (oneType == Object.class && twoType == Object.class) {
}
if (oneType == Object.class) {
if (twoType == Object.class) {
}
if (twoType == Object.class) {
}
}
Assert.assertTrue(assert1 || assert2);
Assert.assertEquals(samplePair,mapperWithModule().readValue(expectedJson1,pairType));
}