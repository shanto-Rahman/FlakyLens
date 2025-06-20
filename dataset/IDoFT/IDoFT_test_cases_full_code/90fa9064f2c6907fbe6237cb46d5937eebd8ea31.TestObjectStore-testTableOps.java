/** 
 * Test table operations
 */
@Test public void testTableOps() throws MetaException, InvalidObjectException, NoSuchObjectException, InvalidInputException {
  Database db1=new DatabaseBuilder().setName(DB1).setDescription("description").setLocation("locationurl").build(conf);
  objectStore.createDatabase(db1);
  StorageDescriptor sd1=new StorageDescriptor(ImmutableList.of(new FieldSchema("pk_col","double",null)),"location",null,null,false,0,new SerDeInfo("SerDeName","serializationLib",null),null,null,null);
  HashMap<String,String> params=new HashMap<>();
  params.put("EXTERNAL","false");
  Table tbl1=new Table(TABLE1,DB1,"owner",1,2,3,sd1,null,params,null,null,"MANAGED_TABLE");
  objectStore.createTable(tbl1);
  List<String> tables=objectStore.getAllTables(DEFAULT_CATALOG_NAME,DB1);
  Assert.assertEquals(1,tables.size());
  Assert.assertEquals(TABLE1,tables.get(0));
  StorageDescriptor sd2=new StorageDescriptor(ImmutableList.of(new FieldSchema("fk_col","double",null)),"location",null,null,false,0,new SerDeInfo("SerDeName","serializationLib",null),null,null,null);
  Table newTbl1=new Table("new" + TABLE1,DB1,"owner",1,2,3,sd2,null,params,null,null,"MANAGED_TABLE");
  newTbl1.setOwner("role1");
  newTbl1.setOwnerType(PrincipalType.ROLE);
  objectStore.alterTable(DEFAULT_CATALOG_NAME,DB1,TABLE1,newTbl1,null);
  tables=objectStore.getTables(DEFAULT_CATALOG_NAME,DB1,"new*");
  Assert.assertEquals(1,tables.size());
  Assert.assertEquals("new" + TABLE1,tables.get(0));
  Table alteredTable=objectStore.getTable(DEFAULT_CATALOG_NAME,DB1,"new" + TABLE1);
  Assert.assertEquals("Owner of table was not altered",newTbl1.getOwner(),alteredTable.getOwner());
  Assert.assertEquals("Owner type of table was not altered",newTbl1.getOwnerType(),alteredTable.getOwnerType());
  objectStore.createTable(tbl1);
  tables=objectStore.getAllTables(DEFAULT_CATALOG_NAME,DB1);
  Assert.assertEquals(2,tables.size());
  List<SQLForeignKey> foreignKeys=objectStore.getForeignKeys(DEFAULT_CATALOG_NAME,DB1,TABLE1,null,null);
  Assert.assertEquals(0,foreignKeys.size());
  SQLPrimaryKey pk=new SQLPrimaryKey(DB1,TABLE1,"pk_col",1,"pk_const_1",false,false,false);
  pk.setCatName(DEFAULT_CATALOG_NAME);
  objectStore.addPrimaryKeys(ImmutableList.of(pk));
  SQLForeignKey fk=new SQLForeignKey(DB1,TABLE1,"pk_col",DB1,"new" + TABLE1,"fk_col",1,0,0,"fk_const_1","pk_const_1",false,false,false);
  objectStore.addForeignKeys(ImmutableList.of(fk));
  foreignKeys=objectStore.getForeignKeys(DEFAULT_CATALOG_NAME,null,null,DB1,"new" + TABLE1);
  Assert.assertEquals(1,foreignKeys.size());
  List<SQLForeignKey> fks=objectStore.getForeignKeys(DEFAULT_CATALOG_NAME,null,null,DB1,"new" + TABLE1);
  if (fks != null) {
    for (    SQLForeignKey fkcol : fks) {
      objectStore.dropConstraint(fkcol.getCatName(),fkcol.getFktable_db(),fkcol.getFktable_name(),fkcol.getFk_name());
    }
  }
  foreignKeys=objectStore.getForeignKeys(DEFAULT_CATALOG_NAME,DB1,TABLE1,null,null);
  Assert.assertEquals(0,foreignKeys.size());
  foreignKeys=objectStore.getForeignKeys(DEFAULT_CATALOG_NAME,null,null,DB1,"new" + TABLE1);
  Assert.assertEquals(0,foreignKeys.size());
  objectStore.dropTable(DEFAULT_CATALOG_NAME,DB1,TABLE1);
  tables=objectStore.getAllTables(DEFAULT_CATALOG_NAME,DB1);
  Assert.assertEquals(1,tables.size());
  objectStore.dropTable(DEFAULT_CATALOG_NAME,DB1,"new" + TABLE1);
  tables=objectStore.getAllTables(DEFAULT_CATALOG_NAME,DB1);
  Assert.assertEquals(0,tables.size());
  objectStore.dropDatabase(db1.getCatalogName(),DB1);
}
