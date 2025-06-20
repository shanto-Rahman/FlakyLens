public void test_jsonField() throws Exception {
vo.setID(123);//IT
Assert.assertEquals("{\"iD\":123}",text);
Assert.assertEquals(123,JSON.parseObject(text,VO.class).getID());
}