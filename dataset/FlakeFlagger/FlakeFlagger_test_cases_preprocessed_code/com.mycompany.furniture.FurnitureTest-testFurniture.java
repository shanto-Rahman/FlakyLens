@Test public void testFurniture(){
entityMgr.persist(chair);//RW
entityMgr.persist(couch);//RW
entityMgr.persist(table);//RW
entityMgr.persist(desk);//RW
Furniture f1=entityMgr.find(Furniture.class,1);//RW
Furniture f2=entityMgr.find(Furniture.class,2);//RW
Furniture f3=entityMgr.find(Furniture.class,3);//RW
Furniture f4=entityMgr.find(Furniture.class,4);//RW
assertEquals(Chair.class,f1.getClass());
assertEquals(Couch.class,f2.getClass());
assertEquals(Table.class,f3.getClass());
assertEquals(Desk.class,f4.getClass());
}