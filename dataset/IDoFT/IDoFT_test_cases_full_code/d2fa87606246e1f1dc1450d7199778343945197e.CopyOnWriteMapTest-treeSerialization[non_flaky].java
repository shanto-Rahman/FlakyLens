/** 
 * Verify that an empty CopyOnWriteMap.Tree can be serialized, and that serialization form is the same as a standard TreeMap.
 */
@Test public void treeSerialization(){
  TreeData td=new TreeData();
  XStream2 xs=new XStream2();
  String out=xs.toXML(td);
  assertTrue(out.replaceAll("\\s+","").equals("<hudson.util.CopyOnWriteMapTest_-TreeData>" + "<map1/><map2/></hudson.util.CopyOnWriteMapTest_-TreeData>") || out.replaceAll("\\s+","").equals("<hudson.util.CopyOnWriteMapTest_-TreeData>" + "<map2/><map1/></hudson.util.CopyOnWriteMapTest_-TreeData>"));
  TreeData td2=(TreeData)xs.fromXML(out);
  assertTrue(td2.map1.isEmpty());
  assertTrue(td2.map2.isEmpty());
  td=new TreeData(String.CASE_INSENSITIVE_ORDER);
  td.map1.put("foo1","bar1");
  td.map2.put("foo2","bar2");
  out=xs.toXML(td);
  assertTrue(out.replaceAll(">\\s+<","><").equals("<hudson.util.CopyOnWriteMapTest_-TreeData><map1>" + "<comparator class=\"java.lang.String$CaseInsensitiveComparator\"/>" + "<entry><string>foo1</string><string>bar1</string></entry></map1>"+ "<map2><comparator class=\"java.lang.String$CaseInsensitiveComparator\""+ " reference=\"../../map1/comparator\"/>"+ "<entry><string>foo2</string><string>bar2</string></entry></map2>"+ "</hudson.util.CopyOnWriteMapTest_-TreeData>") || out.replaceAll(">\\s+<","><").equals("<hudson.util.CopyOnWriteMapTest_-TreeData><map2>" + "<comparator class=\"java.lang.String$CaseInsensitiveComparator\"/>" + "<entry><string>foo2</string><string>bar2</string></entry></map2>"+ "<map1><comparator class=\"java.lang.String$CaseInsensitiveComparator\""+ " reference=\"../../map2/comparator\"/>"+ "<entry><string>foo1</string><string>bar1</string></entry></map1>"+ "</hudson.util.CopyOnWriteMapTest_-TreeData>"));
  td2=(TreeData)xs.fromXML(out);
  assertEquals("bar1",td2.map1.get("foo1"));
  assertEquals("bar2",td2.map2.get("foo2"));
}
