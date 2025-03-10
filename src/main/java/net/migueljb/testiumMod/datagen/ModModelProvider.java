package net.migueljb.testiumMod.datagen;


import net.migueljb.testiumMod.block.ModBlocks;
import net.migueljb.testiumMod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.particle.BlockMarker;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.obj.ObjMaterialLibrary;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, "testiummod");
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        //blocks
        blockModels.createTrivialCube(ModBlocks.GREENIUM_ORE_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.REDIUM_ORE_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.TESTIUMR_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.TESTIUMG_BLOCK.get());
        //blockModels.createTrivialCube(ModBlocks.TESTIUMR_STAIRS.get());
        System.out.println(ResourceLocation.fromNamespaceAndPath("minecraft", "oak_stairs"));
        //blockModels.createWeightedPressurePlate(ModBlocks.TESTIUMR_PRESSURE_PLATE.get(), ModBlocks.TESTIUMR_BLOCK.get());
        //Pressure Plates
        blockModels.createWeightedPressurePlate(ModBlocks.TESTIUMR_PRESSURE_PLATE.get(), ModBlocks.TESTIUMR_BLOCK.get());
        blockModels.createWeightedPressurePlate(ModBlocks.TESTIUMG_PRESSURE_PLATE.get(), ModBlocks.TESTIUMG_BLOCK.get());
        //Buttons
        blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMR_BLOCK.get()).button(ModBlocks.TESTIUMR_BUTTON.get());
        blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMG_BLOCK.get()).button(ModBlocks.TESTIUMG_BUTTON.get());
        //Stairs
        blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMR_BLOCK.get()).stairs(ModBlocks.TESTIUMR_STAIRS.get());
        blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMG_BLOCK.get()).stairs(ModBlocks.TESTIUMG_STAIRS.get());
        //Slabs
        blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMR_BLOCK.get()).slab(ModBlocks.TESTIUMR_SLAB.get());
        blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMG_BLOCK.get()).slab(ModBlocks.TESTIUMG_SLAB.get());
        //Fences
        blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMR_BLOCK.get()).fence(ModBlocks.TESTIUMR_FENCE.get());
        blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMG_BLOCK.get()).fence(ModBlocks.TESTIUMG_FENCE.get());
        //Fence Gates
        blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMR_BLOCK.get()).fenceGate(ModBlocks.TESTIUMR_FENCE_GATE.get());
        blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMG_BLOCK.get()).fenceGate(ModBlocks.TESTIUMG_FENCE_GATE.get());
        //Doors
        blockModels.createDoor(ModBlocks.TESTIUMR_DOOR.get());
        blockModels.createTrapdoor(ModBlocks.TESTIUMR_TRAPDOOR.get());
        //Walls
        blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMR_BLOCK.get()).wall(ModBlocks.TESTIUMR_WALL.get());
        blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMG_BLOCK.get()).wall(ModBlocks.TESTIUMG_WALL.get());
        /*
        blockModels.createSlab(ModBlocks.TESTIUMR_SLAB.get(),
                ModelTemplates.SLAB_BOTTOM.getDefaultModelLocation(ModBlocks.TESTIUMR_BLOCK.get()),
                ModelTemplates.SLAB_TOP.getDefaultModelLocation(ModBlocks.TESTIUMR_BLOCK.get()),
                ModelTemplates.CUBE_ALL.getDefaultModelLocation(ModBlocks.TESTIUMR_BLOCK.get())
        );
        */

        //blockModels.createButton(ModBlocks.TESTIUMR_BUTTON.get(), Blocks.STONE_BUTTON.);
        //BlockModelGenerators.createButton(ModBlocks.TESTIUMR_BUTTON.get(),)
        //blockModels.copyModel(Blocks.ACACIA_STAIRS, ModBlocks.TESTIUMR_STAIRS.get());
        //blockModels.createTrapdoor(ModBlocks.TESTIUMR_TRAPDOOR.get());
        //blockModels.createTrapdoor(ModBlocks.TESTIUMR_TRAPDOOR.get());
        //blockModels.copyTrapdoorModel(ModBlocks.TESTIUMR_TRAPDOOR.get(), ModBlocks.TESTIUMR_BLOCK.get());

        //blockModels.createWeightedPressurePlate(ModBlocks.TESTIUMR_PRESSURE_PLATE.get(),
        //        Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
        //blockModels.createDoor(ModBlocks.TESTIUMR_DOOR.get());
        //blockModels.familyWithExistingFullBlock(ModBlocks.TESTIUMR_BLOCK.get()).button(ModBlocks.TESTIUMR_BUTTON.get());
        //blockModels.family(ModBlocks.TESTIUMR_BLOCK.get()).fence(ModBlocks.TESTIUMR_FENCE.get());
        //blockModels.family(ModBlocks.TESTIUMR_BLOCK.get()).fenceGate(ModBlocks.TESTIUMR_FENCE_GATE.get());
        //blockModels.family(ModBlocks.TESTIUMR_BLOCK.get()).wall(ModBlocks.TESTIUMR_WALL.get());
        //blockModels.family(ModBlocks.TESTIUMR_BLOCK.get()).slab(ModBlocks.TESTIUMR_SLAB.get());
        //BlockModelGenerators.createSlab(ModBlocks.TESTIUMR_SLAB.get(),
        //        ModelTemplates.SLAB_TOP.getDefaultModelLocation(ModBlocks.TESTIUMR_SLAB.get()),
        //        ModelTemplates.SLAB_BOTTOM.getDefaultModelLocation(ModBlocks.TESTIUMR_SLAB.get()),
        //       ModelTemplates.CUBE_ALL.getDefaultModelLocation(ModBlocks.TESTIUMR_BLOCK.get()));



       // BlockModelGenerators.createSimpleBlock(ModBlocks.TESTIUMR_STAIRS.get(),
       //         ResourceLocation.fromNamespaceAndPath("minecraft","oak_stairs"));
        // blockModels.family(ModBlocks.TESTIUMR_STAIRS.get()).stairs(ModBlocks.TESTIUMR_STAIRS.get());
        //blockModels.family(ModBlocks.TESTIUMR_BLOCK.get()).stairs(ModBlocks.TESTIUMR_STAIRS.get());
/*
        BlockModelGenerators.createStairs(ModBlocks.TESTIUMR_STAIRS.get(),
                ModelTemplates.STAIRS_INNER.getDefaultModelLocation(ModBlocks.TESTIUMR_BLOCK.get()),
                ModelTemplates.STAIRS_STRAIGHT.getDefaultModelLocation(ModBlocks.TESTIUMR_BLOCK.get()),
                ModelTemplates.STAIRS_OUTER.getDefaultModelLocation(ModBlocks.TESTIUMR_BLOCK.get()));


        BlockModelGenerators.createStairs(ModBlocks.TESTIUMR_STAIRS.get(),
                ModelTemplates.STAIRS_INNER.getDefaultModelLocation(Blocks.OAK_STAIRS),
                ModelTemplates.STAIRS_STRAIGHT.getDefaultModelLocation(Blocks.OAK_STAIRS),
                ModelTemplates.STAIRS_OUTER.getDefaultModelLocation(Blocks.OAK_STAIRS));

        blockModels.createTrivialBlock(ModBlocks.TESTIUMR_BLOCK.get(), new TexturedModel.Provider() {
            @Override
            public TexturedModel get(Block block) {
                return null;
            }
        });
        // Register your custom block that uses a specific model
        //Block testium_stairs = ModBlocks.TESTIUMR_STAIRS.get();
        //ResourceLocation modelLoc = TexturedModel.CUBE.create(ModBlocks.TESTIUMR_STAIRS.get(), blockModels.modelOutput);
        /*BlockModelGenerators.createStairs(ModBlocks.TESTIUMR_STAIRS.get(),
                ResourceLocation.fromNamespaceAndPath("minecraft", "oak_stairs"),
                ResourceLocation.fromNamespaceAndPath("minecraft", "oak_stairs"),
                ResourceLocation.fromNamespaceAndPath("minecraft", "oak_stairs"));

         */
        blockModels.createGenericCube(ModBlocks.TAINTER_BLOCK.get());
        //blockModels.createDoor(ModBlocks.TESTIUMR_DOOR.get());
        //blockModels.family(ModBlocks.TESTIUMR_BLOCK.get()).stairs(ModBlocks.TESTIUMR_STAIRS.get());


        //items
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
        itemModels.generateFlatItem(ModBlocks.TESTIUMR_BLOCK.get().asItem(), ModelTemplates.FLAT_ITEM);
        //itemModels.generateFlatItem(ModBlocks.TESTIUMR_PRESSURE_PLATE.asItem(), ModBlocks.TESTIUMR_BLOCK.asItem(), ModelTemplates.FLAT_ITEM);
        //itemModels.generateFlatItem(ModBlocks.TESTIUMR_PRESSURE_PLATE.get().asItem(), ModelTemplates.FLAT_ITEM);
        //itemModels.generateFlatItem(Item.byBlock(ModBlocks.TESTIUMR_SLAB.get()), ModelTemplates.FLAT_ITEM);
        //itemModels.generateFlatItem(ModBlocks.TESTIUMR_STAIRS.get().asItem(), ModelTemplates.FLAT_ITEM);
        //itemModels.generateFlatItem(ModBlocks.TESTIUMR_BUTTON.get().asItem(), ModelTemplates.FLAT_ITEM);

        //itemModels.generateFlatItem(ModBlocks.TESTIUMR_TRAPDOOR.get().asItem(), ModelTemplates.FLAT_ITEM);
        //itemModels.generateFlatItem(ModBlocks.TESTIUMR_SLAB.get().asItem(), ModelTemplates.FLAT_ITEM);
        //itemModels.generateFlatItem(ModBlocks.TESTIUMR_DOOR.get().asItem(), ModelTemplates.FLAT_ITEM);

    }


    private void blockWithItem(DeferredBlock<?> deferredBlock){

    }

}
