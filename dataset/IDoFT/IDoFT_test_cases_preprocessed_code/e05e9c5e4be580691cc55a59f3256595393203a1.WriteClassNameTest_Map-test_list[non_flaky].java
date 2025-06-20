public void test_list() throws Exception {
model.setTables(tables);//IT
assertEquals("{\"tables\":{\"1001\":{\"@type\":\"com.alibaba.json.bvt.writeClassName.WriteClassNameTest_Map$ExtTable\",\"id\":1001},\"1002\":{}}}",json);
assertEquals("{\"tables\":{\"1001\":{\"id\":1001},\"1002\":{}}}",JSON.toJSONString(jsonObject,SerializerFeature.MapSortField));
assertEquals(ExtTable.class,model2.getTables().get("1001").getClass());//IT
}