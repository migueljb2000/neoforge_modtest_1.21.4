package net.migueljb.testiumMod.util;

import net.migueljb.testiumMod.TestiumMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{

        public static final TagKey<Block> NEEDS_TESTIUM_TOOL = createTag("needs_testium_tool");
        public static final TagKey<Block> INCORRECT_FOR_TESTIUM_TOOL = createTag("incorrect_for_testium_tool");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TestiumMod.MOD_ID, name));
        }

    }
    public static class Items{
        public static final TagKey<Item> GREEN_ITEMS = createTag("green_items");
        public static final TagKey<Item> RED_ITEMS = createTag("red_items");
        public static final TagKey<Item> TESTIUM_INGOTS = createTag("testium_ingots");
        public static final TagKey<Item> TESTIUM_ARMOR = createTag("testium_armor");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TestiumMod.MOD_ID, name));
        }
    }
}
