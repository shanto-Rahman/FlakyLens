@Test public void testFormatSimple(){
assertEquals("{\n" + "  \"price\": 8.95,\n" + "  \"category\": \"reference\"\n"+ "}",helper.format("{\"price\": 8.95,\"category\": \"reference\"}"));
}