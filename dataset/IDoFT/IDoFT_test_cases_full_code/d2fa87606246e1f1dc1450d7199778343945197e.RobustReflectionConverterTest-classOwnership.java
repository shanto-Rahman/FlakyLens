@Test public void classOwnership(){
  XStream xs=new XStream2(clazz -> {
    Owner o=clazz.getAnnotation(Owner.class);
    return o != null ? o.value() : null;
  }
);
  String prefix1=RobustReflectionConverterTest.class.getName() + "_-";
  String prefix2=RobustReflectionConverterTest.class.getName() + "$";
  Enchufla s1=new Enchufla();
  s1.number=1;
  s1.direction="North";
  Moonwalk s2=new Moonwalk();
  s2.number=2;
  s2.boot=new Boot();
  s2.lover=new Billy();
  Moonwalk s3=new Moonwalk();
  s3.number=3;
  s3.boot=new Boot();
  s3.jacket=new Jacket();
  s3.lover=new Jean();
  Bild b=new Bild();
  b.steppes=new Steppe[]{s1,s2,s3};
  Projekt p=new Projekt();
  p.bildz=new Bild[]{b};
  assertEquals("<Projekt><bildz><Bild><steppes>" + "<Enchufla plugin='p1'><number>1</number><direction>North</direction></Enchufla>" + "<Moonwalk plugin='p2'><number>2</number><boot/><lover class='Billy' plugin='p3'/></Moonwalk>"+ "<Moonwalk plugin='p2'><number>3</number><boot/><jacket/><lover class='Jean' plugin='p4'/></Moonwalk>"+ "</steppes></Bild></bildz></Projekt>",xs.toXML(p).replace(prefix1,"").replace(prefix2,"").replaceAll("\r?\n *","").replace('"','\''));
  Moonwalk s=(Moonwalk)xs.fromXML("<" + prefix1 + "Moonwalk plugin='p2'><lover class='"+ prefix2+ "Billy' plugin='p3'/></"+ prefix1+ "Moonwalk>");
  assertEquals(Billy.class,s.lover.getClass());
}
