package net.migueljb.testiumMod.datagen;

import net.migueljb.testiumMod.TestiumMod;
import net.migueljb.testiumMod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
            .add(ModBlocks.TESTIUMR_BLOCK.get());
    this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.GREENIUM_ORE_BLOCK.get())
            .add(ModBlocks.REDIUM_ORE_BLOCK.get());
    }
}
