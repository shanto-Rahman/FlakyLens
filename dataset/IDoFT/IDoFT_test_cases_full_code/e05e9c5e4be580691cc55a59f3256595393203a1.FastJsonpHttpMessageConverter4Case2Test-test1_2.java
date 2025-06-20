@Test public void test1_2() throws Exception {
  JSONObject json=new JSONObject();
  json.put("id",123);
  json.put("name","哈哈哈");
  ResultActions actions=mockMvc.perform((post("/fastjson/test1?callback=fnUpdateSome").characterEncoding("UTF-8").content(json.toJSONString()).contentType(MediaType.APPLICATION_JSON)));
  actions.andDo(print());
  actions.andExpect(status().isOk()).andExpect(content().contentType(APPLICATION_JAVASCRIPT)).andExpect(content().string("/**/fnUpdateSome({\"name\":\"哈哈哈\",\"id\":123})"));
}
