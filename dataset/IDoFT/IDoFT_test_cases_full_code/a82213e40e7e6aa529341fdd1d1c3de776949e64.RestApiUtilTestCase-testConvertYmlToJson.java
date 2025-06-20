@Test(description="Test convert Yaml to JSON") public void testConvertYmlToJson() throws Exception {
  final String testYaml="list:\n" + "    item 1\n" + "    item 2\n"+ "items:\n"+ "    - name: item1\n"+ "      price: 10\n"+ "\n"+ "    - name: item2\n"+ "      price: 20";
  final String expectedJson="{\"list\":\"item 1 item 2\",\"items\":[{\"name\":\"item1\",\"price\":10},{\"name\":\"item2\",\"" + "price\":20}]}";
  String actualJson=RestApiUtil.convertYmlToJson(testYaml);
  Assert.assertEquals(actualJson,expectedJson);
}
