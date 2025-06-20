public void testUpperSnakeCaseTranslations() throws Exception {
  String json=_ucWithUnderscoreMapper.writeValueAsString(new PersonBean("Joe","Sixpack",42));
  assertEquals("{\"FIRST_NAME\":\"Joe\",\"LAST_NAME\":\"Sixpack\",\"AGE\":42}",json);
  PersonBean result=_ucWithUnderscoreMapper.readValue(json,PersonBean.class);
  assertEquals("Joe",result.firstName);
  assertEquals("Sixpack",result.lastName);
  assertEquals(42,result.age);
}
