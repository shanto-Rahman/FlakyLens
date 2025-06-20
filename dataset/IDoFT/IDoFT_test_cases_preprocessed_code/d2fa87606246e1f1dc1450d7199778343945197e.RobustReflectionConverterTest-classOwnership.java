@Test public void classOwnership(){
assertEquals("<Projekt><bildz><Bild><steppes>" + "<Enchufla plugin='p1'><number>1</number><direction>North</direction></Enchufla>" + "<Moonwalk plugin='p2'><number>2</number><boot/><lover class='Billy' plugin='p3'/></Moonwalk>"+ "<Moonwalk plugin='p2'><number>3</number><boot/><jacket/><lover class='Jean' plugin='p4'/></Moonwalk>"+ "</steppes></Bild></bildz></Projekt>",xs.toXML(p).replace(prefix1,"").replace(prefix2,"").replaceAll("\r?\n *","").replace('"','\''));
assertEquals(Billy.class,s.lover.getClass());
}