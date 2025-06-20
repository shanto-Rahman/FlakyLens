@Test public void testFormatSimple(){
assertEquals("{\n" + "    \"price\": 8.95,\n" + "    \"category\": \"reference\"\n"+ "}",helper.format("{\"category\": \"reference\",\"price\": 8.95}"));
}