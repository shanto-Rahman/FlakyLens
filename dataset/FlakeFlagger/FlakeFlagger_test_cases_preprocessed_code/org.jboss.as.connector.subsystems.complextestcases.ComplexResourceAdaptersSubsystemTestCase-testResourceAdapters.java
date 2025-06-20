@Test public void testResourceAdapters() throws Exception {
if (model == null) return;
Assert.assertEquals(raCommonModel.asString(),"A",raCommonModel.get("config-properties","Property","value").asString());
Assert.assertEquals(raCommonModel.get("beanvalidationgroups").asString(),raCommonModel.get("beanvalidationgroups").asString(),"[\"Class0\",\"Class00\"]");
Assert.assertEquals(raAdminModel.asString(),"D",raAdminModel.get("config-properties","Property","value").asString());
Assert.assertEquals(raConnModel.asString(),"B",raConnModel.get("config-properties","Property","value").asString());
Assert.assertEquals(raConnModel.asString(),"C",raConnModel.get("recovery-plugin-properties","Property").asString());
}