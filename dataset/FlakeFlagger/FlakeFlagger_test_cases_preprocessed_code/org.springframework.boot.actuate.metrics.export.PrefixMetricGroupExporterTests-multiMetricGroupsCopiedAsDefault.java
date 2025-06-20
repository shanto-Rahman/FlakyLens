@Test public void multiMetricGroupsCopiedAsDefault(){
assertEquals(1,this.writer.countGroups());
assertEquals(2,Iterables.collection(this.writer.findAll("foo")).size());
}