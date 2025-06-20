@Test public void testSortingOnString(){
assertEquals("{\n" + "    \"extraKey\": 2,\n" + "    \"parameters\": [\n"+ "        {\n"+ "            \"price\": 18.95,\n"+ "            \"category\": \"areference\"\n"+ "        },\n"+ "        {\n"+ "            \"price\": 8.95,\n"+ "            \"category\": \"reference\"\n"+ "        }\n"+ "    ]\n"+ "}",helper.format(h));
}