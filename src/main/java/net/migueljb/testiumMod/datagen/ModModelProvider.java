package net.migueljb.testiumMod.datagen;


import net.migueljb.testiumMod.block.ModBlocks;
import net.migueljb.testiumMod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, "testiummod");
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createTrivialCube(ModBlocks.GREENIUM_ORE_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.REDIUM_ORE_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.TESTIUMR_BLOCK.get());

        // Register your custom block that uses a specific model
        blockModels.createGenericCube(ModBlocks.TAINTER_BLOCK.get());


        itemModels.generateFlatItem(ModItems.TESTIUM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TESTIUMG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TESTIUMR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.TESTER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CHISEL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.REDIUM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RED_COAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_GREEN_BEEF.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.GREEN_BEEF.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.GREENIUM.get(), ModelTemplates.FLAT_ITEM);



    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){

    }



}
