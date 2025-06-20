@Test @DisplayName("Test allowed value") void testAllowedValue(){
  MaterialTagSetting setting=new MaterialTagSetting("test",tag);
  SlimefunItem item=TestUtilities.mockSlimefunItem(plugin,"MATERIAL_SETTING_TEST_2",new CustomItem(Material.DIAMOND,"&cTest"));
  item.addItemSetting(setting);
  item.register(plugin);
  List<String> tagContents=tag.getValues().stream().map(Material::name).collect(Collectors.toList());
  Assertions.assertIterableEquals(tagContents,setting.getValue());
  List<String> materials=Arrays.asList(Material.REDSTONE.name(),Material.DIAMOND.name());
  setting.update(materials);
  Assertions.assertIterableEquals(materials,setting.getValue());
}
