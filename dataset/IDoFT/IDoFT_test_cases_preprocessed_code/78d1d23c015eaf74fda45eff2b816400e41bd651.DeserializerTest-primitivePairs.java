@Test public void primitivePairs() throws Exception {
if (oneType == Object.class && twoType == Object.class) {
}
if (oneType == Object.class) {
if (twoType == Object.class) {
}
if (twoType == Object.class) {
}
}
Assert.assertEquals(expectedJson,mapperWithModule().writeValueAsString(samplePair));
Assert.assertEquals(samplePair,mapperWithModule().readValue(expectedJson,pairType));
}