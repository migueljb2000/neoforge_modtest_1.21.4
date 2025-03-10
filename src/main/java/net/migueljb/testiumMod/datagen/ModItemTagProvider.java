package net.migueljb.testiumMod.datagen;

import net.migueljb.testiumMod.TestiumMod;
import net.migueljb.testiumMod.block.ModBlocks;
import net.migueljb.testiumMod.item.ModItems;
import net.migueljb.testiumMod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, String modId) {
        super(output, lookupProvider, blockTags, TestiumMod.MOD_ID);
    }

    public static final TagKey<Item> GREEN_ITEMS = TagKey.create(
            // The registry key. The type of the registry must match the generic type of the tag.
            Registries.ITEM,
            // The location of the tag. This example will put our tag at data/testiummod/tags/blocks/example_tag.json.
            ResourceLocation.fromNamespaceAndPath("testiummod", "green_items")
    );
    public static final TagKey<Item> RED_ITEMS = TagKey.create(
            // The registry key. The type of the registry must match the generic type of the tag.
            Registries.ITEM,
            // The location of the tag. This example will put our tag at data/examplemod/tags/blocks/example_tag.json.
            ResourceLocation.fromNamespaceAndPath("testiummod", "red_items")
    );

    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture, CompletableFuture<TagLookup<Block>> tagLookupCompletableFuture) {
        super(packOutput, providerCompletableFuture, tagLookupCompletableFuture);

    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.GREEN_ITEMS)
                .add(ModItems.GREEN_BEEF.get())
                .add(ModItems.GREENIUM.get())
                .add(ModItems.RAW_GREEN_BEEF.get())
                .add(ModItems.TESTIUMG.get())
                .add(ModBlocks.TESTIUMG_PRESSURE_PLATE.get().asItem())
                .add(ModBlocks.TESTIUMG_BUTTON.get().asItem())
                .add(ModBlocks.TESTIUMG_STAIRS.get().asItem())
                .add(ModBlocks.TESTIUMG_BLOCK.get().asItem())
                .add(Item.byBlock(ModBlocks.TESTIUMG_SLAB.get()));
        tag(ModTags.Items.RED_ITEMS)
                .add(ModItems.RED_COAL.get())
                .add(ModItems.REDIUM.get())
                .add(ModItems.TESTIUMR.get())
                .add(ModBlocks.TESTIUMR_PRESSURE_PLATE.get().asItem())
                .add(ModBlocks.TESTIUMR_BUTTON.get().asItem())
                .add(ModBlocks.TESTIUMR_STAIRS.get().asItem())
                .add(ModBlocks.TESTIUMR_BLOCK.get().asItem())
                .add(Item.byBlock(ModBlocks.TESTIUMR_SLAB.get()));
    //.add(Item.byBlock(ModBlocks.TESTIUMR_TRAPDOOR.get()));




    }
}
