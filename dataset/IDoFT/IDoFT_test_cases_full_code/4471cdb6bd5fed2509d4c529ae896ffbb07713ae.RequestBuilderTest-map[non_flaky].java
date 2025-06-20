@Test public void map(){
  Open builder=new Open();
  Map<String,Object> map=new LinkedHashMap<String,Object>();
  map.put("color","green");
  map.put("insect","bee");
  String element=builder.formatMap("examples",map);
  assertEquals("<examples><color>green</color><insect>bee</insect></examples>",element);
}
