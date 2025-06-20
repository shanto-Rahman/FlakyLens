@Test void applyWithNullObject() throws IOException {
assertFalse(result.isValid());
assertEquals(1,result.getResult().size());
assertTrue(result.getResult().containsKey("object"));
assertEquals("managed_repository",result.getResult().get("object").get(0).getCategory());
assertEquals("isnull",result.getResult().get("object").get(0).getType());
assertEquals("object",result.getResult().get("object").get(0).getAttribute());
}