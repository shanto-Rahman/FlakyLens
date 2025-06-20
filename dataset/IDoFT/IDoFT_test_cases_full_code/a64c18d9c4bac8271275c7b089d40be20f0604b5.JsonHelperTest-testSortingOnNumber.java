@Test public void testSortingOnNumber(){
  String h=helper.sort("{\n" + "  \"extraKey\": 2,\n" + "  \"parameters\": [\n"+ "    {\n"+ "      \"category\": \"reference\",\n"+ "      \"price\": 8.95\n"+ "    },\n"+ "    {\n"+ "      \"category\": \"areference\",\n"+ "      \"price\": 18.95\n"+ "    }\n"+ "  ]\n"+ "}","$.parameters","$.price");
  assertEquals("{\n" + "    \"extraKey\": 2,\n" + "    \"parameters\": [\n"+ "        {\n"+ "            \"price\": 8.95,\n"+ "            \"category\": \"reference\"\n"+ "        },\n"+ "        {\n"+ "            \"price\": 18.95,\n"+ "            \"category\": \"areference\"\n"+ "        }\n"+ "    ]\n"+ "}",helper.format(h));
}
