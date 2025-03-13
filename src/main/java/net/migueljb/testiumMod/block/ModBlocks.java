package net.migueljb.testiumMod.block;


import net.migueljb.testiumMod.TestiumMod;
import net.migueljb.testiumMod.block.custom.TainterBlock;
import net.migueljb.testiumMod.block.custom.TestiumLampBlock;
import net.migueljb.testiumMod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
                     .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMR_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumr_block",
            TESTIUMR_BLOCK,
            new Item.Properties());

    public static final DeferredBlock<Block> TESTIUMG_BLOCK = BLOCKS.register("testiumg_block",
            registryName -> new Block(
                    BlockBehaviour.Properties.of()
                            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                            .setId(ResourceKey.create(Registries.BLOCK, registryName))
            ));
    public static final DeferredItem<BlockItem> TESTIUMG_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumg_block",
            TESTIUMG_BLOCK,
            new Item.Properties());

    public static final DeferredBlock<Block> TAINTER_BLOCK = BLOCKS.register("tainter_block",
            registryName -> new TainterBlock(
            BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TAINTER_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "tainter_block",
            TAINTER_BLOCK,
            new Item.Properties());


    public static final DeferredBlock<Block> GREENIUM_ORE_BLOCK = BLOCKS.register("greenium_ore_block",
            registryName -> new Block(
                    BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.GLASS)
                            .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> GREENIUM_ORE_ITEM = ITEMS.registerSimpleBlockItem(
            "greenium_ore_block",
            GREENIUM_ORE_BLOCK,
            new Item.Properties());

    public static final DeferredBlock<Block> REDIUM_ORE_BLOCK = BLOCKS.register("redium_ore_block",
            registryName -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.GLASS)
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> REDIUM_ORE_ITEM = ITEMS.registerSimpleBlockItem(
            "redium_ore_block",
            REDIUM_ORE_BLOCK,
            new Item.Properties());
    //NON BLOCKS BLOCKS
    //Pressure Plates
    public static final DeferredBlock<WeightedPressurePlateBlock> TESTIUMR_PRESSURE_PLATE = BLOCKS.register("testiumr_pressure_plate",
            registryName -> new WeightedPressurePlateBlock(10, BlockSetType.IRON,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMR_PRESSURE_PLATE_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumr_pressure_plate",
            TESTIUMR_PRESSURE_PLATE,
            new Item.Properties());

    public static final DeferredBlock<WeightedPressurePlateBlock> TESTIUMG_PRESSURE_PLATE = BLOCKS.register("testiumg_pressure_plate",
            registryName -> new WeightedPressurePlateBlock(15, BlockSetType.GOLD,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMG_PRESSURE_PLATE_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumg_pressure_plate",
            TESTIUMG_PRESSURE_PLATE,
            new Item.Properties());
    //Buttons
    public static final DeferredBlock<ButtonBlock> TESTIUMR_BUTTON = BLOCKS.register("testiumr_button",
            registryName -> new ButtonBlock(BlockSetType.IRON, 10,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().setId(ResourceKey.create(Registries.BLOCK, registryName))));

    public static final DeferredItem<BlockItem> TESTIUMR_BUTTON_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumr_button",
            TESTIUMR_BUTTON,
            new Item.Properties());
    public static final DeferredBlock<ButtonBlock> TESTIUMG_BUTTON = BLOCKS.register("testiumg_button",
            registryName -> new ButtonBlock(BlockSetType.GOLD, 15,
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().setId(ResourceKey.create(Registries.BLOCK, registryName))));

    public static final DeferredItem<BlockItem> TESTIUMG_BUTTON_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumg_button",
            TESTIUMG_BUTTON,
            new Item.Properties());
    //Stairs
    public static final DeferredBlock<StairBlock> TESTIUMR_STAIRS = BLOCKS.register("testiumr_stairs",
            registryName -> new StairBlock(ModBlocks.TESTIUMR_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMR_STAIRS_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumr_stairs",
            TESTIUMR_STAIRS,
            new Item.Properties());
    public static final DeferredBlock<StairBlock> TESTIUMG_STAIRS = BLOCKS.register("testiumg_stairs",
            registryName -> new StairBlock(ModBlocks.TESTIUMG_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMG_STAIRS_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumg_stairs",
            TESTIUMG_STAIRS,
            new Item.Properties());
    //Slabs
    public static final DeferredBlock<SlabBlock> TESTIUMR_SLAB = BLOCKS.register("testiumr_slab",
            registryName -> new SlabBlock(
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMR_SLAB_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumr_slab",
            TESTIUMR_SLAB,
            new Item.Properties());
    public static final DeferredBlock<SlabBlock> TESTIUMG_SLAB = BLOCKS.register("testiumg_slab",
            registryName -> new SlabBlock(
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMG_SLAB_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumg_slab",
            TESTIUMG_SLAB,
            new Item.Properties());
    //Fences
    public static final DeferredBlock<FenceBlock> TESTIUMR_FENCE = BLOCKS.register("testiumr_fence",
            registryName -> new FenceBlock(
                    BlockBehaviour.Properties.of().strength(2f).setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMR_FENCE_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumr_fence",
            TESTIUMR_FENCE,
            new Item.Properties());
    public static final DeferredBlock<FenceBlock> TESTIUMG_FENCE = BLOCKS.register("testiumg_fence",
            registryName -> new FenceBlock(
                    BlockBehaviour.Properties.of().strength(2f).setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMG_FENCE_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumg_fence",
            TESTIUMG_FENCE,
            new Item.Properties());
    //Fence Gates
    public static final DeferredBlock<FenceGateBlock> TESTIUMR_FENCE_GATE = BLOCKS.register("testiumr_fence_gate",
            registryName -> new FenceGateBlock(
                    BlockBehaviour.Properties.of().strength(2f).setId(ResourceKey.create(Registries.BLOCK, registryName)),
            SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final DeferredItem<BlockItem> TESTIUMR_FENCE_GATE_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumr_fence_gate",
            TESTIUMR_FENCE_GATE,
            new Item.Properties());
    public static final DeferredBlock<FenceGateBlock> TESTIUMG_FENCE_GATE = BLOCKS.register("testiumg_fence_gate",
            registryName -> new FenceGateBlock(
                    BlockBehaviour.Properties.of().strength(2f).setId(ResourceKey.create(Registries.BLOCK, registryName)),
                    SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final DeferredItem<BlockItem> TESTIUMG_FENCE_GATE_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumg_fence_gate",
            TESTIUMG_FENCE_GATE,
            new Item.Properties());
    //Doors
    public static final DeferredBlock<DoorBlock> TESTIUMR_DOOR = BLOCKS.register("testiumr_door",
            registryName -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMR_DOOR_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumr_door",
            TESTIUMR_DOOR,
            new Item.Properties());

    public static final DeferredBlock<DoorBlock> TESTIUMG_DOOR = BLOCKS.register("testiumg_door",
            registryName -> new DoorBlock(BlockSetType.GOLD, BlockBehaviour.Properties.of().strength(2f).noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMG_DOOR_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumg_door",
            TESTIUMG_DOOR,
            new Item.Properties());
    //TrapDoors
    public static final DeferredBlock<TrapDoorBlock> TESTIUMR_TRAPDOOR = BLOCKS.register("testiumr_trapdoor",
            registryName -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMR_TRAPDOOR_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumr_trapdoor",
            TESTIUMR_TRAPDOOR,
            new Item.Properties());

    public static final DeferredBlock<TrapDoorBlock> TESTIUMG_TRAPDOOR = BLOCKS.register("testiumg_trapdoor",
            registryName -> new TrapDoorBlock(BlockSetType.GOLD, BlockBehaviour.Properties.of().strength(2f).noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMG_TRAPDOOR_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumg_trapdoor",
            TESTIUMG_TRAPDOOR,
            new Item.Properties());
    //Walls
    public static final DeferredBlock<WallBlock> TESTIUMR_WALL = BLOCKS.register("testiumr_wall",
            registryName -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMR_WALL_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumr_wall",
            TESTIUMR_WALL,
            new Item.Properties());
    public static final DeferredBlock<WallBlock> TESTIUMG_WALL = BLOCKS.register("testiumg_wall",
            registryName -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMG_WALL_ITEM = ITEMS.registerSimpleBlockItem(
            "testiumg_wall",
            TESTIUMG_WALL,
            new Item.Properties());

    //Lamp
    public static final DeferredBlock<Block> TESTIUM_LAMP = BLOCKS.register("testium_lamp",
            registryName -> new TestiumLampBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(TestiumLampBlock.CLICKED) ? 15 : 0)
                    .setId(ResourceKey.create(Registries.BLOCK, registryName))));
    public static final DeferredItem<BlockItem> TESTIUMG_LAMP_ITEM = ITEMS.registerSimpleBlockItem(
            "testium_lamp",
            TESTIUM_LAMP,
            new Item.Properties());
/*

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
*/
    public static  void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
