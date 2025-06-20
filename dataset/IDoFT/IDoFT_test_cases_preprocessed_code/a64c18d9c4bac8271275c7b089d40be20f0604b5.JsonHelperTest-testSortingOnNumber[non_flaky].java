@Test public void testSortingOnNumber(){
JSONAssert.assertEquals("{\n" + "  \"extraKey\": 2,\n" + "  \"parameters\": [\n"+ "    {\n"+ "      \"price\": 8.95,\n"+ "      \"category\": \"reference\"\n"+ "    },\n"+ "    {\n"+ "      \"price\": 18.95,\n"+ "      \"category\": \"areference\"\n"+ "    }\n"+ "  ]\n"+ "}",helper.format(h),false);
}