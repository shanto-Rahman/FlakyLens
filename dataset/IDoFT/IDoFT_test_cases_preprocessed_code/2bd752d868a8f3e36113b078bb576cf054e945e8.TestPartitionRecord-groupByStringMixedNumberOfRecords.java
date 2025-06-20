@Test public void groupByStringMixedNumberOfRecords(){
assertEquals(3L,out.stream().filter(ff -> ff.getAttribute("record.count").equals("1")).count());
assertEquals(1L,out.stream().filter(ff -> ff.getAttribute("record.count").equals("2")).count());
assertEquals(1L,out.stream().filter(ff -> ff.getAttribute("person-name").equals(name)).count());
}