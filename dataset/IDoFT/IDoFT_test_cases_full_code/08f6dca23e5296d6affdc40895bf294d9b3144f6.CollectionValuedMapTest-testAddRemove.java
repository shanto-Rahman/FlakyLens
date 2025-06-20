/** 
 * Tests add/remove (again).
 */
@Test public void testAddRemove(){
  CollectionValuedMap<Integer,Integer> fooMap=new CollectionValuedMap<>();
  for (int i=0; i < 4; i++) {
    for (int j=0; j < 4; j++) {
      fooMap.add(new Integer(i),new Integer(j));
    }
  }
  fooMap.remove(new Integer(2));
  Assert.assertEquals("{0=[0, 1, 2, 3], 1=[0, 1, 2, 3], 3=[0, 1, 2, 3]}",fooMap.toString());
}
