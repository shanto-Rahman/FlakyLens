public void testIdWithJacksonRules() throws Exception {
assertEquals(expected,json);
assertEquals(3,result.size());
assertEquals(Long.valueOf(11),result.get(0).id);
assertEquals(Long.valueOf(22),result.get(1).id);
assertEquals(Long.valueOf(33),result.get(2).id);
}