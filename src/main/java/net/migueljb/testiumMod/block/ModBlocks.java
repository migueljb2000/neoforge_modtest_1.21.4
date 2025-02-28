package net.migueljb.testiumMod.block;


import net.migueljb.testiumMod.TestiumMod;
import net.migueljb.testiumMod.block.custom.TainterBlock;
import net.migueljb.testiumMod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.function.Supplier;

import static net.migueljb.testiumMod.item.ModItems.ITEMS;
import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TestiumMod.MOD_ID);

    public static final DeferredBlock<Block> TESTIUMR_BLOCK = BLOCKS.register("testiumr_block",
        registryName -> new Block(
             BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
                     .setId(ResourceKey.create(Registries.BLOCK, registryName))
            ));
    public static final DeferredItem<BlockItem> TESTIUMR_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumr_block",
            TESTIUMR_BLOCK,
            new Item.Properties()
    );

    public static final DeferredBlock<Block> TAINTER_BLOCK = BLOCKS.register("tainter_block",
            registryName -> new TainterBlock(
            BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))
            ));
    public static final DeferredItem<BlockItem> TAINTER_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "tainter_block",
            TAINTER_BLOCK,
            new Item.Properties()
    );

    public static final DeferredBlock<Block> GREENIUM_ORE_BLOCK = BLOCKS.register("greenium_ore_block",
            registryName -> new Block(
                    BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.GLASS)
                            .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> GREENIUM_ORE_ITEM = ITEMS.registerSimpleBlockItem(
            "greenium_ore_block",
            GREENIUM_ORE_BLOCK,
            new Item.Properties()
    );

    public static final DeferredBlock<Block> REDIUM_ORE_BLOCK = BLOCKS.register("redium_ore_block",
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.GLASS)
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> REDIUM_ORE_ITEM = ITEMS.registerSimpleBlockItem(
            "redium_ore_block",
            REDIUM_ORE_BLOCK,
            new Item.Properties()
    );

    //Non block Blocks
    public static final DeferredBlock<StairBlock> TESTIUMR_STAIRS = BLOCKS.register("testiumr_stairs",
            registryName -> new StairBlock(ModBlocks.TESTIUMR_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<SlabBlock> TESTIUMR_SLAB = BLOCKS.register("testiumr_slab",
            registryName -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> TESTIUMR_PRESSURE_PLATE = BLOCKS.register("testiumr_pressure_plate",
            registryName -> new PressurePlateBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<ButtonBlock> TESTIUMR_BUTTON = BLOCKS.register("testiumr_button",
            registryName -> new ButtonBlock(BlockSetType.IRON, 20,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<FenceBlock> TESTIUMR_FENCE = BLOCKS.register("testiumr_fence",
            registryName -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<FenceGateBlock> TESTIUMR_FENCE_GATE = BLOCKS.register("testiumr_fence_gate",
            registryName -> new FenceGateBlock(WoodType.BAMBOO , BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<WallBlock> TESTIUMR_WALL = BLOCKS.register("testiumr_wall",
            registryName -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> TESTIUMR_DOOR = BLOCKS.register("testiumr_door",
            registryName -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<TrapDoorBlock> TESTIUMR_TRAPDOOR = BLOCKS.register("testiumr_trapdoor",
            registryName -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static  void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
