@Test public void testOrder() throws Exception {
Assert.assertEquals("There should be exactly 6 modules but there are not",6,modules.size());
Assert.assertEquals(module.get("code").asString(),"module-" + i);
}