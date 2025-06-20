@Test public void testJackson() throws JsonProcessingException {
Assert.assertTrue(json.contains("\"testObjectA1\": \"id1\""));
Assert.assertTrue(json.contains("\"testObjectA2\": \"id1\""));
Assert.assertTrue(json.contains("\"testObjectB1\": {"));
Assert.assertTrue(json.contains("\"testObjectB2\": \"id2\""));
Assert.assertTrue(json.contains("\"testObjectC1\": {"));
Assert.assertTrue(json.contains("\"testObjectC2\": \"id3\""));
Assert.assertTrue(json.contains("\"testObjectD1\": \"id4\""));
Assert.assertTrue(json.contains("\"testObjectD2\": \"id4\""));
Assert.assertTrue(json.contains("\"testObjectE1\": \"id5\""));
Assert.assertTrue(json.contains("\"testObjectE2\": {"));
Assert.assertTrue(json.contains("\"testObjectE3\": {"));
}