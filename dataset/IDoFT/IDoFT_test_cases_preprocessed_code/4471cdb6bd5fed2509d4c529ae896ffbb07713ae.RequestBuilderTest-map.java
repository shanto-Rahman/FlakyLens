@Test public void map(){
String element=builder.formatMap("examples",map);//IT
assertEquals("<examples><color>green</color><insect>bee</insect></examples>",element);
}