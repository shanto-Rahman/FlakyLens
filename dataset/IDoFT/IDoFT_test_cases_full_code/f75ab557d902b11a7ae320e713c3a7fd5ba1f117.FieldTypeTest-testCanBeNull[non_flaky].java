@Test public void testCanBeNull() throws Exception {
  Field[] fields=CanBeNull.class.getDeclaredFields();
  Arrays.sort(fields,new Comparator<Field>(){
    public int compare(    Field a,    Field b){
      return b.getName().compareTo(a.getName());
    }
  }
);
  assertTrue(fields.length >= 2);
  Field field=fields[1];
  FieldType fieldType=FieldType.createFieldType(databaseType,CanBeNull.class.getSimpleName(),field,CanBeNull.class);
  assertTrue(fieldType.isCanBeNull());
  field=fields[0];
  fieldType=FieldType.createFieldType(databaseType,CanBeNull.class.getSimpleName(),field,CanBeNull.class);
  assertFalse(fieldType.isCanBeNull());
}
