public void test_jsonField() throws Exception {
  VO vo=new VO();
  vo.setID(123);
  String text=JSON.toJSONString(vo);
  Assert.assertEquals("{\"iD\":123}",text);
  Assert.assertEquals(123,JSON.parseObject(text,VO.class).getID());
}
