package net.migueljb.testiumMod.block;


import net.migueljb.testiumMod.TestiumMod;
import net.migueljb.testiumMod.block.custom.TainterBlock;
import net.migueljb.testiumMod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
/*
    public static final DeferredBlock<Block> GREENIUM_ORE_BLOCK = registerBlock("greenium_ore_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, BLOCKS.getRegistryName()))
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.GLASS)
            ));
    public static final DeferredBlock<Block> REDIUM_ORE_BLOCK = registerBlock("redium_ore_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, BLOCKS.getRegistryName()))
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.GLASS)
            ));

 */

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
    /*
    public static final DeferredBlock<Block> TAINTER_BLOCK = BLOCKS.registerBlock("tainter_block",
            TainterBlock::new,
            BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
            );


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.registerItem(name,
                Item::new,
                new Item.Properties());
    }
*/
/*
    public static final RegistryObject<Block> GREENIUM_ORE_BLOCK = registerBlock("greenium_ore_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.GLASS)
                    .setId(BLOCKS.key("greenium_ore_block"))));

    public static final RegistryObject<Block> REDIUM_ORE_BLOCK = registerBlock("redium_ore_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.GLASS)
                    .setId(BLOCKS.key("redium_ore_block"))));

    public static final RegistryObject<Block> TESTIUMR_BLOCK = registerBlock("testiumr_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
                    .setId(BLOCKS.key("testiumr_block"))));

    public static final RegistryObject<Block> TAINTER_BLOCK = registerBlock("tainter_block",
            ()-> new TainterBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)
                    .setId(BLOCKS.key("tainter_block"))));

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ITEMS.key(name))));
    }


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        //registerBlockItem("testiumr_block", TESTIUMR_BLOCK);
        //registerBlockItem("tainter_block", TAINTER_BLOCK);
        return toReturn;
    }
*/
    public static  void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
