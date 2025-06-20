@Test public void testValueLiteralString(){
assertEquals("[null, null, [1, 2, 3]]",new ValueLiteralExpression(new Integer[][]{null,null,{1,2,3}}).toString());
assertEquals("[null, null, ['1', '2', '3', 'Dog''s']]",new ValueLiteralExpression(new String[][]{null,null,{"1","2","3","Dog's"}},DataTypes.ARRAY(DataTypes.ARRAY(DataTypes.STRING()))).toString());
assertEquals("{key1=1, key2=2, key3=3}",new ValueLiteralExpression(map,DataTypes.MAP(DataTypes.STRING(),DataTypes.INT())).toString());
assertEquals("{key1=1, key2=2, key3=3}",new ValueLiteralExpression(map,DataTypes.MULTISET(DataTypes.STRING())).toString());
}