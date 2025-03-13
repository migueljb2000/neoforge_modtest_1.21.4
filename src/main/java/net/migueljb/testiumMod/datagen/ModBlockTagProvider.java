package net.migueljb.testiumMod.datagen;

import net.migueljb.testiumMod.TestiumMod;
import net.migueljb.testiumMod.block.ModBlocks;
import net.migueljb.testiumMod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TestiumMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.GREENIUM_ORE_BLOCK.get())
            .add(ModBlocks.REDIUM_ORE_BLOCK.get())
            .add(ModBlocks.TAINTER_BLOCK.get())
            .add(ModBlocks.TESTIUMR_PRESSURE_PLATE.get())
            .add(ModBlocks.TESTIUMG_PRESSURE_PLATE.get())
            .add(ModBlocks.TESTIUMR_BUTTON.get())
            .add(ModBlocks.TESTIUMG_BUTTON.get())
            .add(ModBlocks.TESTIUMR_BLOCK.get())
            .add(ModBlocks.TESTIUMG_BLOCK.get())
            .add(ModBlocks.TESTIUMR_STAIRS.get())
            .add(ModBlocks.TESTIUMG_STAIRS.get())
            .add(ModBlocks.TESTIUMR_SLAB.get())
            .add(ModBlocks.TESTIUMG_SLAB.get());


            //.add(ModBlocks.TESTIUMR_TRAPDOOR.get());
    this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.GREENIUM_ORE_BLOCK.get())
            .add(ModBlocks.REDIUM_ORE_BLOCK.get())
            .add(ModBlocks.TESTIUMR_SLAB.get())
            .add(ModBlocks.TESTIUMG_SLAB.get());

    this.tag(BlockTags.FENCES)
            .add(ModBlocks.TESTIUMG_FENCE.get())
            .add(ModBlocks.TESTIUMR_FENCE.get());

    this.tag(BlockTags.FENCE_GATES)
            .add(ModBlocks.TESTIUMR_FENCE_GATE.get())
            .add(ModBlocks.TESTIUMG_FENCE_GATE.get());

    this.tag(BlockTags.DOORS)
            .add(ModBlocks.TESTIUMR_DOOR.get())
            .add(ModBlocks.TESTIUMG_DOOR.get());
    this.tag(BlockTags.TRAPDOORS)
            .add(ModBlocks.TESTIUMR_TRAPDOOR.get())
            .add(ModBlocks.TESTIUMG_TRAPDOOR.get());

    this.tag(BlockTags.WALLS)
            .add(ModBlocks.TESTIUMR_WALL.get())
            .add(ModBlocks.TESTIUMG_WALL.get());

    this.tag(ModTags.Blocks.NEEDS_TESTIUM_TOOL)
            .addTag(BlockTags.NEEDS_IRON_TOOL);


    this.tag(ModTags.Blocks.INCORRECT_FOR_TESTIUM_TOOL)
            .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
            .remove(ModTags.Blocks.NEEDS_TESTIUM_TOOL);

    }

}
